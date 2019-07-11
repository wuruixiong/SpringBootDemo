package wrx.spbdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wrx.spbdemo.bean.Boat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "boat")
public class BoatCtrl {

    @RequestMapping(value = "/addOne")
    public ModelAndView addOne(Model model) {
        model.addAttribute(new Boat());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("boat_add");
        return modelAndView;
    }




}
