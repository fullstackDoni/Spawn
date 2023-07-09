package kz.finalbitlab.spawn.controller;

import groovy.transform.stc.POJO;
import kz.finalbitlab.spawn.model.User;
import kz.finalbitlab.spawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String signInPage() {
        return "signin";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDenied() {
        return "403";
    }

    @GetMapping(value = "/sign-up-page")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_confirm_password") String confirmPassword,
                           @RequestParam(name = "full_name") String fullName) {
        if (password.equals(confirmPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if(newUser!=null){
                return "redirect:/sign-up-page?success";
            }else {
                return "redirect:/sign-up-page?emailerror?";
            }
        }else{
            return "redirect:/sign-up-page?passworderror";
        }
    }

}
