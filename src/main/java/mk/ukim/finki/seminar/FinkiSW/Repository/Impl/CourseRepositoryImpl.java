package mk.ukim.finki.seminar.FinkiSW.Repository.Impl;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.Model.Course;
import mk.ukim.finki.seminar.FinkiSW.Repository.CourseRepository;
import mk.ukim.finki.seminar.FinkiSW.Repository.JpaRepository.CourseJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private CourseJpaRepository repository;

    public CourseRepositoryImpl(CourseJpaRepository repository) { this.repository = repository; }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Course addNewCourse(Course course) {
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());
        repository.save(course);
        return course;
    }

    @Override
    public Course deleteCourseById(Long id) {
        Course course = repository.findById(id).get();
        repository.delete(course);
        return course;
    }

    @Override
    public Course editCourseById(Long id, Course course) {
        Course c = repository.findById(id).get();
        c.setName(course.getName());
        c.setStudyYear(course.getStudyYear());
        c.setUpdatedAt(LocalDateTime.now());
        repository.save(c);
        return c;
    }

    @Override
    public void addInfoToCourse(Long id, Course course) {
        Course c = repository.findById(id).get();
        c.setInfo(course.getInfo());
        c.setUpdatedAt(LocalDateTime.now());
        repository.save(c);
    }

    @Override
    public List<Course> getCourseByUser(String username, String type) {
        List<Course> selectedCourses = new ArrayList<>();
        List<Course> allCourses = getAllCourses();
        for (Course course: allCourses) {
            if(type.equals("t")){
                for (User u: course.getTeachers()) {
                    if(u.getUsername().equals(username)){
                        selectedCourses.add(course);
                    }
                }
            } else if(type.equals("s")){
                for (User u: course.getStudents()) {
                    if(u.getUsername().equals(username)){
                        selectedCourses.add(course);
                    }
                }
            }

        }
        return selectedCourses;
    }

    @Override
    public void editUsersByCourse(Long id, List<User> users, String type) {
        Course course = repository.findById(id).get();
        Set<User> userSet = new HashSet<>(users);
        if(type.equals("s")){
            course.setStudents(userSet);
        } else if(type.equals("t")) {
            course.setTeachers(userSet);
        }
        course.setUpdatedAt(LocalDateTime.now());
        repository.save(course);
    }

}
