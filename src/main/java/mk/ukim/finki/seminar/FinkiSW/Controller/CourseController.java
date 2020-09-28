package mk.ukim.finki.seminar.FinkiSW.Controller;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.Model.Course;
import mk.ukim.finki.seminar.FinkiSW.Service.Impl.CourseServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) { this.courseService = courseService; }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('TEACHER_USER') or hasAuthority('STUDENT_USER')")
    public List<Course> getAllCourses(){ return courseService.getAllCourses(); }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('TEACHER_USER') or hasAuthority('STUDENT_USER')")
    public Course getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseById(id);
    }

    @RequestMapping(value ="/{type}/{username}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('TEACHER_USER') or hasAuthority('STUDENT_USER')")
    public List<Course> getCoursesByUser(@PathVariable("username") String username, @PathVariable("type") String type){
        return courseService.getCourseByUser(username,type);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Course addNewCourse(@Valid @RequestBody Course course){
        return courseService.addNewCourse(course);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Course deleteCourseById(@PathVariable("id") Long id){
        return courseService.deleteCourseById(id);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Course editCourseById(@PathVariable("id") Long id, @Valid @RequestBody Course course){
        return courseService.editCourseById(id, course);
    }

    @RequestMapping(value ="users/{type}/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public void addUsersToCourse(@PathVariable("id") Long id, @Valid @RequestBody List<User> users, @PathVariable("type") String type){
        courseService.addUsersToCourse(id,users,type);
    }

    @RequestMapping(value ="othersUsers/{type}/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getAllUsersNotInCourse(@PathVariable("id") Long id, @PathVariable("type") String type){
        return courseService.getAllUsersNotInCourse(id,type);
    }

    @RequestMapping(value ="/info/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('TEACHER_USER')")
    public void addInfoToCourse(@PathVariable("id") Long id, @Valid @RequestBody Course course){
        courseService.addInfoToCourse(id, course);
    }

    @RequestMapping(value ="/date/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('TEACHER_USER')")
    public void updateDates(@PathVariable("id") Long id, @Valid @RequestBody Course course){
        courseService.updateDates(id, course);
    }



}
