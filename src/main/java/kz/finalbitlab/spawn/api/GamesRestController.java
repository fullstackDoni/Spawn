package kz.finalbitlab.spawn.api;

import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
@RequiredArgsConstructor
public class GamesRestController {

    private final GameService gameService;


    @GetMapping
    public List<Game> gameList() {
        return gameService.getGames();
    }

    @GetMapping(value = "{id}")
    public Game getGame(@PathVariable(name = "id") Long id) {
        return gameService.getGame(id);
    }

    @PostMapping()
    public Game addGame(@RequestBody Game game) {
        return gameService.addGame(game);
    }

    @PutMapping
    public Game updateGame(@RequestBody Game game) {
        return gameService.updateGame(game);
    }
    @DeleteMapping(value = "{id}")
    public void deleteGame(@PathVariable(name = "id") Long id){
        gameService.deleteGame(id);
    }

}
