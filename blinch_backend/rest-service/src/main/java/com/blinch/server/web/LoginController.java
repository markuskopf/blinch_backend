package com.blinch.server.web;

import com.blinch.server.domain.customer.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;


/**
 * Created by markuskopf on 20/01/16.
 */

@RestController
public class LoginController {

    @RequestMapping(value="/api/v1/login", method= RequestMethod.GET)
    public String login(User customer) {
        return "login";
    }

    @RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
    public String loginCustomer(@Valid User customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("password", customer.getPassword());

        return "result";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(ModelMap model, Principal principal) {
        String name = principal.getName(); //get logged in username
        model.addAttribute("username", name);

        return "You're successful logged in...";
    }
}
