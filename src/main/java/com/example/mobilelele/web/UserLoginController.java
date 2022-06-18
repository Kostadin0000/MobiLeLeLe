package com.example.mobilelele.web;

import com.example.mobilelele.DTO.UserLogin;
import com.example.mobilelele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userLogin")
    private UserLogin userLogin() {
        return new UserLogin();
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(@Valid @ModelAttribute UserLogin userLogin, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLogin", userLogin);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLogin",bindingResult);
            return "redirect:/users/login";
        }

        if (userService.login(userLogin)) {
            userService.login(userLogin.getUsername());
        } else {
            redirectAttributes.addFlashAttribute("userLogin", userLogin);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }

        return "redirect:/";
    }

    @PostMapping("/users/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }


}
