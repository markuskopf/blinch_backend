package com.blinch.server.controller;

import com.blinch.server.domain.customer.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by markuskopf on 20/01/16.
 */

@Controller
public class LoginController {

    @RequestMapping(value="/api/v1/login", method= RequestMethod.GET)
    public String login(Customer customer) {
        return "login";
    }

    @RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
    public String loginCustomer(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("password", customer.getPassword());

        return "result";
    }
}
