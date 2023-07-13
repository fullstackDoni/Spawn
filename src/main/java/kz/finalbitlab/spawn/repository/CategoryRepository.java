package kz.finalbitlab.spawn.repository;

import jakarta.transaction.Transactional;
import kz.finalbitlab.spawn.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
