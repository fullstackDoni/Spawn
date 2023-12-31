package kz.finalbitlab.spawn.repository;

import jakarta.transaction.Transactional;
import kz.finalbitlab.spawn.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game,Long> {
}
