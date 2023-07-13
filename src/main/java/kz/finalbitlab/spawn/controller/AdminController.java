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

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin-panel")
    public String adminPanel(Model model){
        return "admin";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/add-game")
    public String addGame(Game game) {
        gameRepository.save(game);
        return "redirect:/";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/add-game")
    public String addGame(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("category", categoryList);
        return "addGame";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/add-category")
    public String addCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/add-category")
    public String addCategory() {
        return "addCategory";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/users")
    public String Users(Model model) {
        return "users";
    }
}
