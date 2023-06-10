package kz.finalbitlab.spawn.repository;

import jakarta.transaction.Transactional;
import kz.finalbitlab.spawn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
