package kz.finalbitlab.spawn.controller;

import kz.finalbitlab.spawn.model.Category;
import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.model.User;
import kz.finalbitlab.spawn.repository.CategoryRepository;
import kz.finalbitlab.spawn.repository.GameRepository;
import kz.finalbitlab.spawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(value = "/")
    public String index(Model model) {
        List<Game> gameList = gameRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("games", gameList);
        return "index";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "aboutus";
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
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror?";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }
    }

    @GetMapping(value = "update-password-page")
    public String updatepasswordPage() {
        return "update-password";
    }

    @PostMapping(value = "/to-update-password")
    public String toUpdatePassword(@RequestParam(name = "user_old_password") String oldPassword,
                                   @RequestParam(name = "user_new_password") String newPassword,
                                   @RequestParam(name = "user_confirm_new_password") String ConfirmNewPassword) {
        if (newPassword.equals(ConfirmNewPassword)) {
            User user = userService.updatePassword(newPassword, oldPassword);
            if (user != null) {
                return "redirect:/update-password-page?success";
            } else {
                return "redirect:/update-password-page?oldpassworderror";
            }

        } else {
            return "redirect:/update-password-page?passworddismatch";
        }
    }

}
