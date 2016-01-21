package com.blinch.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by markuskopf on 21/01/16.
 */

//@Controller
public class HomeController {

//    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
