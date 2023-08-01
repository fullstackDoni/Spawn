package kz.finalbitlab.spawn.controller;

import kz.finalbitlab.spawn.dto.GameDTO;
import kz.finalbitlab.spawn.model.Category;
import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.repository.CategoryRepository;
import kz.finalbitlab.spawn.repository.GameRepository;
import kz.finalbitlab.spawn.service.UserService;
import kz.finalbitlab.spawn.service.CategoryService;
import kz.finalbitlab.spawn.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ModeratorController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PreAuthorize("hasAnyRole('ROLE_MODERATOR')")
    @GetMapping(value = "/games")
    public String Games(Model model){
        List<Game> gameList = gameRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("games", gameList);
        return "games";
    }
    @PreAuthorize("hasAnyRole('ROLE_MODERATOR')")
    @PostMapping(value = "/save-game")
    public String saveGame(Game game){
        gameRepository.save(game);
        return "redirect:/";
    }
    @PreAuthorize("hasAnyRole('ROLE_MODERATOR')")
    @PostMapping(value = "/delete-game")
    public String delete(@RequestParam(name = "id") Long id){
        gameRepository.deleteById(id);
        return "redirect:/";
    }
    @PreAuthorize("hasAnyRole('ROLE_MODERATOR')")
    @GetMapping(value = "/change-game/{id}")
    public String ChangeGame(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("category",categoryService.getCategory());
        model.addAttribute("game",gameService.getGame(id));
        return "changegame";
    }
    @PreAuthorize("hasAnyRole('ROLE_MODERATOR')")
    @GetMapping(value = "/delete-game")
    public String Delete(Model model){
        List<Game> gameList = gameRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("games", gameList);
        return "games";
    }
}
