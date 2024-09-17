package com.miraclestudio.livesol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("pages/login");
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:/dashboard");
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        return new ModelAndView("pages/dashboard");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("pages/register");
    }
}
