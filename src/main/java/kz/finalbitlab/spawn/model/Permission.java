package kz.finalbitlab.spawn.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_permission")
public class Permission implements GrantedAuthority {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;

    @Override
    public String getAuthority(){
        return this.role;
    }
}
