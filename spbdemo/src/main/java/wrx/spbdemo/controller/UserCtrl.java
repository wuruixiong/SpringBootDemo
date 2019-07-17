package wrx.spbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wrx.spbdemo.bean.User;
import wrx.spbdemo.mapper.UserMapper;

import javax.servlet.http.HttpSession;
import java.util.List;

import static wrx.spbdemo.bean.Keys.LOGIN_INFO;

@RestController
@RequestMapping(value = "user")
public class UserCtrl {

    @Autowired
    private UserMapper mUserMapper;

    @RequestMapping("index")
    public String hello() {
        return "hello UserCtrl";
    }

    @RequestMapping("/toIndex")
    public ModelAndView toIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userIndex");
        if (session.getAttribute(LOGIN_INFO) instanceof User) {
            User user = ((User) session.getAttribute(LOGIN_INFO));
            modelAndView.addObject("name", user.getName());
        }
        return modelAndView;
    }

    @RequestMapping("selectAll")
    public List<User> selectAll() {
        List<User> users = mUserMapper.selectAllUser();
        return users;
    }

    @RequestMapping("selectUserByUid")
    public List<User> selectUserByUid() {
        List<User> users = mUserMapper.selectUserByUid(1);
        return users;
    }

    @RequestMapping("selectUserByName")
    public List<User> selectOneByName() {
        List<User> users = mUserMapper.selectUserByName("white");
        return users;
    }

    @RequestMapping("addOne")
    public String addOne() {
        mUserMapper.addOne(new User("white", "wpsd", "98766@10.com"));
        return "add success";
    }

    @RequestMapping("updateOne")
    public String updateOne() {
        User userNew = new User(5, "white", "wpsd", "657@34.com");
        List<User> users = mUserMapper.selectUserByUid(userNew.getUid());
        if (users.size() == 1) {
            if (users.get(0).getUid().equals(userNew.getUid())&&
            users.get(0).getPassword().equals(userNew.getPassword())) {
                mUserMapper.updateName(userNew);
                return "update success";
            }
        }
        return  "update fail";
    }

    @RequestMapping("deleteOne")
    public String deleteOne() {
        //mUserMapper.deleteOne(new User(3,"white", "wpsd", "98766@10.com"));
        User user = new User();
        user.setUid(4);
        user.setName("white");
        user.setPassword("wpsd");
        mUserMapper.deleteOne(user);
        return "delete success";
    }

    @GetMapping("/login")
    public ModelAndView loginGet(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView loginPost(@ModelAttribute User user, HttpSession httpSession) {
        List<User> users = mUserMapper.selectUserByNamePwd(user);
        ModelAndView modelAndView = new ModelAndView();
        if (users.size() == 1) {
            modelAndView.setViewName("userIndex");
            modelAndView.addObject("name", user.getName());

            httpSession.setAttribute(LOGIN_INFO, users.get(0));

            return modelAndView;
        } else if (users.size() > 1) {
            System.out.print("user login error, more then one user.");
            modelAndView.setViewName("error");
            return modelAndView;
        } else {
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    @GetMapping("/signin")
    public ModelAndView signInGet(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("sign_in");
    }

    @PostMapping("/signin")
    public ModelAndView signInPost(@ModelAttribute User user) {
        mUserMapper.addOne(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userIndex");
        modelAndView.addObject("name", user.getName());
        return modelAndView;
    }




}


