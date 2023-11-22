package ar.edu.ies6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping ({"/index","/","/home"})
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
