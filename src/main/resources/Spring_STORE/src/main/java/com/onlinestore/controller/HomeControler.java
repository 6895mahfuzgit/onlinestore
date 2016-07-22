package com.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MahfuzCSE'11 on 24-Jun-16.
 */

@Controller
public class HomeControler {


    @RequestMapping("/")

    public String Home() {

        return "home";

    }

    @RequestMapping("/login")

    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {


        if (error != null) {

            model.addAttribute("error", "Invalid username and password");
        }
        if (logout != null)

        {
            model.addAttribute("msg", "You Have Been Logout Successfully!");
        }


        return "login";
    }
}
