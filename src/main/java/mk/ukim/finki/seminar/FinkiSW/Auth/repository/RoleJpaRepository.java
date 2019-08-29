package mk.ukim.finki.seminar.FinkiSW.Auth.repository;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role,Long> {
}
