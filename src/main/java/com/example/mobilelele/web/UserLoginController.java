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

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }



}
