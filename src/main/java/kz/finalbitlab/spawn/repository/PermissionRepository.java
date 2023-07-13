package kz.finalbitlab.spawn.repository;

import jakarta.transaction.Transactional;
import kz.finalbitlab.spawn.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
