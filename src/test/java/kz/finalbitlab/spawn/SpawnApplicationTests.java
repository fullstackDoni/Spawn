package kz.finalbitlab.spawn;

import kz.finalbitlab.spawn.dto.GameDTO;
import kz.finalbitlab.spawn.mapper.GameMapper;
import kz.finalbitlab.spawn.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpawnApplicationTests {

	@Autowired
	private GameMapper gameMapper;

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

}
