package com.travelagency.nastokpl.controllers.view.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }
}
