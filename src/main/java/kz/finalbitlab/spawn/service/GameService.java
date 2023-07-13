package kz.finalbitlab.spawn.service;

import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public Game addGame(Game game){
        return gameRepository.save(game);
    }
}
