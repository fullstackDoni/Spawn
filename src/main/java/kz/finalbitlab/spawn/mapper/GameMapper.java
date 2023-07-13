package kz.finalbitlab.spawn.mapper;

import kz.finalbitlab.spawn.dto.GameDTO;
import kz.finalbitlab.spawn.model.Game;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO toDto(Game game);

    Game toModel(GameDTO gameDTO);



    List<GameDTO> toDtoList(List<Game> gameList);

    List<Game> toModelList(List<GameDTO> gameList);
}
