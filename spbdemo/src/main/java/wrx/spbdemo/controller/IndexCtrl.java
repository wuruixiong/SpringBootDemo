package wrx.spbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "FrontEndTest", method = RequestMethod.GET)
    public ModelAndView frontEndTest() {
        ModelAndView modelAndView = new ModelAndView("front_end_test");
        return modelAndView;
    }

    /**
     * session and cookie测试
     */
    @GetMapping(value = "kk")
    public String setSess(HttpServletRequest request, HttpServletResponse response) {

        // 打印session id
        System.out.println("mytest，id:"+request.getSession().getId());

        // 从session中取出一个值，如果浏览器是第一次访问这个接口，该值为空
        Object value = request.getSession().getAttribute("mKey");
        if (value == null) {
            //如果为空就证明是第一次访问，并打印
            value = "";
            System.out.println("mytest，Value:"+"null");
        } else {
            //打印值
            System.out.println("mytest，Value:"+value);
        }
        //每一次返问都多加一个字符
        request.getSession().setAttribute("mKey", value.toString()+"1");
        return value.toString();
    }

    /**
     * session测试
     */
    @GetMapping(value = "kk2")
    public String setSess2(HttpServletRequest request, HttpServletResponse response) {
        // 打印session id,这个session的id打印出来和 kk接口是一致的
        System.out.println("mytest，id:"+request.getSession().getId());
        return "kk2";
    }

    /**
     * cookie测试
     * 可以在浏览器查看cookies
     */
    @GetMapping(value = "kk3")
    public String setCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String value = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("mykey")) {
                System.out.println("mytest, "+"mykey:"+cookie.getValue());
                value = cookie.getValue();
            }
        }
        //每一次add进去的cookie值不同，key相同，所以打印出来的value会越来越长
        response.addCookie(new Cookie("mykey", value+"3"));
        return "kk3";
    }






}
