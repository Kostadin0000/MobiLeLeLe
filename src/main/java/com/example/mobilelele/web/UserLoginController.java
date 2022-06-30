package com.example.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

//    @PostMapping("/users/login-error")
//    public String loginError(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
//                             RedirectAttributes attributes) {
//
//        attributes.addFlashAttribute("bad_credentials", true);
//        attributes.addFlashAttribute("username",userName);
//
//        return "redirect:/users/login";
//    }
}
