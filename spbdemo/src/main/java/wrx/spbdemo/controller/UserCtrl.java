package wrx.spbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wrx.spbdemo.bean.User;
import wrx.spbdemo.mapper.UserMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserCtrl {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("index")
    public String hello() {
        return "hello UserCtrl";
    }

    @RequestMapping("selectAll")
    public List<User> selectAll() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    @RequestMapping("selectUserByUid")
    public List<User> selectUserByUid() {
        List<User> users = userMapper.selectUserByUid(1);
        return users;
    }

    @RequestMapping("selectUserByName")
    public List<User> selectOneByName() {
        List<User> users = userMapper.selectUserByName("white");
        return users;
    }

    @RequestMapping("addOne")
    public String addOne() {
        userMapper.addOne(new User("white", "wpsd", "98766@10.com"));
        return "add success";
    }

    @RequestMapping("updateOne")
    public String updateOne() {
        User userNew = new User(5, "white", "wpsd", "657@34.com");
        List<User> users = userMapper.selectUserByUid(userNew.getUid());
        if (users.size() == 1) {
            if (users.get(0).getUid().equals(userNew.getUid())&&
            users.get(0).getPassword().equals(userNew.getPassword())) {
                userMapper.updateName(userNew);
                return "update success";
            }
        }
        return  "update fail";
    }

    @RequestMapping("deleteOne")
    public String deleteOne() {
        //userMapper.deleteOne(new User(3,"white", "wpsd", "98766@10.com"));
        User user = new User();
        user.setUid(4);
        user.setName("white");
        user.setPassword("wpsd");
        userMapper.deleteOne(user);
        return "delete success";
    }

    @GetMapping("/login")
    public ModelAndView loginGet(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView loginPost(@ModelAttribute User user) {
        List<User> users = userMapper.selectUserByNamePwd(user);
        ModelAndView modelAndView = new ModelAndView();
        if (users.size() == 1) {
            modelAndView.setViewName("userIndex");
            modelAndView.addObject("name", user.getName());
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
        userMapper.addOne(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userIndex");
        modelAndView.addObject("name", user.getName());
        return modelAndView;
    }




}


