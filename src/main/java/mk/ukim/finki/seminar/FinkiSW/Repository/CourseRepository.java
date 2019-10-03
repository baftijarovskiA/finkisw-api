package mk.ukim.finki.seminar.FinkiSW.Repository;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.Model.Course;

import java.util.List;
import java.util.Set;

public interface CourseRepository {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course addNewCourse(Course course);

    Course deleteCourseById(Long id);

    Course editCourseById(Long id, Course course);

    void addInfoToCourse(Long id, Course course);

    List<Course> getCourseByUser(String username, String type);

    void addUsersToCourse(Long id, List<User> users, String type);

    List<User> getAllUsersNotInCourse(Long id, String type);
}
