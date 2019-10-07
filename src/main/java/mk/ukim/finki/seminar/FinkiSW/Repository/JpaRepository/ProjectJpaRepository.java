package mk.ukim.finki.seminar.FinkiSW.Repository.JpaRepository;

import mk.ukim.finki.seminar.FinkiSW.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepository extends JpaRepository<Project,Long> {
}
