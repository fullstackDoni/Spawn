package kz.finalbitlab.spawn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {

    private Long id;
    private String name;
    private int years;
    private String description;
    private String image;
}
