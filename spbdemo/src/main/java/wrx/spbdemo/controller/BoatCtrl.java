package wrx.spbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wrx.spbdemo.bean.Boat;
import wrx.spbdemo.bean.User;
import wrx.spbdemo.mapper.BoatMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static wrx.spbdemo.bean.Keys.LOGIN_INFO;

@RestController
@RequestMapping(value = "boat")
public class BoatCtrl {

    @Autowired
    private BoatMapper mBoatMapper;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping(value = "/addOne")
    public ModelAndView addOneGet(Model model) {
        model.addAttribute(new Boat());
        return new ModelAndView("boat_add");
    }

    @PostMapping(value = "/addOne")
    public ModelAndView addOnePost(@ModelAttribute Boat boat, HttpSession httpSession) {

        User user = null;
        if ( httpSession.getAttribute(LOGIN_INFO) instanceof User) {
            user = (User) httpSession.getAttribute(LOGIN_INFO);
        }

        if (user != null) {
            boat.setUid(user.getUid());
            mBoatMapper.addOne(boat);
        }


        return new ModelAndView("success");

    }





}
