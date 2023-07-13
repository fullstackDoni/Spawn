package kz.finalbitlab.spawn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_games")
@Getter
@Setter
public class Game extends BaseModel{

    @Column(name = "year")
    private int years;

    @Column(name = "image")
    private String image;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Category category;
}
