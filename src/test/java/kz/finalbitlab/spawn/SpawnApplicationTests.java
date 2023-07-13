package kz.finalbitlab.spawn;

import kz.finalbitlab.spawn.dto.GameDTO;
import kz.finalbitlab.spawn.mapper.GameMapper;
import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpawnApplicationTests {

	@Autowired
	private GameMapper gameMapper;

	@Autowired
	private GameService gameService;

	@Test
	void contextLoads() {
	}
	@Test
	void checkGameDto(){
		Game game = new Game();
		GameDTO gameDTO = gameMapper.toDto(game);
		Assertions.assertEquals(game.getName(),gameDTO.getName());
		Assertions.assertEquals(game.getId(),gameDTO.getId());
		Assertions.assertEquals(game.getDescription(),gameDTO.getDescription());
		Assertions.assertEquals(game.getYears(),gameDTO.getYears());
		Assertions.assertEquals(game.getImage(),gameDTO.getImage());
	}
	void checkInsertIntoDb(){
		Game game = new Game();
		GameDTO newGame = gameService.addGame(gameMapper.toDto(game));
		Assertions.assertNotNull(newGame);
		Assertions.assertNotNull(newGame.getId());
		Assertions.assertEquals(game.getName(),newGame.getName());
		Assertions.assertEquals(game.getYears(),newGame.getYears());
		Assertions.assertEquals(game.getImage(),newGame.getImage());
		Assertions.assertEquals(game.getDescription(),newGame.getDescription());
		gameService.deleteGame(game.getId());

	}
}
