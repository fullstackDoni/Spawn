package kz.finalbitlab.spawn.api;

import kz.finalbitlab.spawn.dto.GameDTO;
import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/game")
public class GamesController {

    private final GameService gameService;

    @GetMapping(value = "/get-game-list")
    public List<GameDTO> getGames(){
        return gameService.getGames();
    }
    @PostMapping(value = "/add-game")
    public GameDTO addGame(@RequestBody GameDTO game){
        return gameService.addGame(game);
    }

}
