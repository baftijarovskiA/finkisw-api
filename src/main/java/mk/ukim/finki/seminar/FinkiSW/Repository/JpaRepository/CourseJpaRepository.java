package mk.ukim.finki.seminar.FinkiSW.Repository.JpaRepository;

import mk.ukim.finki.seminar.FinkiSW.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {
}
