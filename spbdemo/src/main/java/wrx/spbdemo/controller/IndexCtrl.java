package wrx.spbdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexCtrl {

    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "wrx");
        return modelAndView;
    }





}
