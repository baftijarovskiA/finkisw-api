package mk.ukim.finki.seminar.FinkiSW.Service.Impl;

import mk.ukim.finki.seminar.FinkiSW.Model.Course;
import mk.ukim.finki.seminar.FinkiSW.Repository.Impl.CourseRepositoryImpl;
import mk.ukim.finki.seminar.FinkiSW.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepositoryImpl repository;

    public CourseServiceImpl(CourseRepositoryImpl repository) { this.repository = repository; }

    @Override
    public List<Course> getAllCourses() {
        return repository.getAllCourses();
    }

    @Override
    public Course getCourseById(Long id) {
        return repository.getCourseById(id);
    }

    @Override
    public Course addNewCourse(Course course) {
        return repository.addNewCourse(course);
    }

    @Override
    public Course deleteCourseById(Long id) {
        return repository.deleteCourseById(id);
    }

    @Override
    public Course editCourseById(Long id, Course course) {
        return repository.editCourseById(id,course);
    }

    @Override
    public void addInfoToCourse(Long id, Course course) {
        repository.addInfoToCourse(id,course);
    }

    @Override
    public List<Course> getCourseByUser(String username,String type) {
        return repository.getCourseByUser(username,type);
    }
}
