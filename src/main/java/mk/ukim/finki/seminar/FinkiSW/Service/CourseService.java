package mk.ukim.finki.seminar.FinkiSW.Service;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.Model.Course;

import java.util.List;
import java.util.Set;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course addNewCourse(Course course);

    Course deleteCourseById(Long id);

    Course editCourseById(Long id, Course course);

    void addInfoToCourse(Long id, Course course);

    List<Course> getCourseByUser(String username, String type);

    void editUsersByCourse(Long id, List<User> users, String type);
}
