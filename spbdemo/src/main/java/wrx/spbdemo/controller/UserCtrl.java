package wrx.spbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wrx.spbdemo.mapper.UserMapper;
import wrx.spbdemo.model.User;

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

        System.out.print("");
        System.out.print("");
        System.out.print("");

        //return "add one success";
        return users;
    }







}
