package mk.ukim.finki.seminar.FinkiSW.Controller;


import mk.ukim.finki.seminar.FinkiSW.Model.Project;
import mk.ukim.finki.seminar.FinkiSW.Service.Impl.ProjectServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectContoller {

    private ProjectServiceImpl projectService;

    public ProjectContoller(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<Project> getAllProjects(){ return projectService.getAllProjects(); }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public List<Project> getAllProjectsByCourse(@PathVariable("id") Long id){
        return projectService.getAllProjectsByCourse(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public Project getProjectById(@PathVariable("id") Long id){
        return projectService.getProjectById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public Project createProject(@Valid @RequestBody Project project){
        return projectService.createProject(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public Project editProjectById(@PathVariable("id") Long id, @Valid @RequestBody Project project){
        return projectService.editProjectById(id,project);
    }

    @RequestMapping(value = "/feedback/{id}/{state}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public void setFeedback(@PathVariable("id") Long id, @PathVariable("state") int state, @Valid @RequestBody Project feedback){
        projectService.setFeedback(id, state, feedback);
    }

    @RequestMapping(value = "/upload/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public void uploadProject(@PathVariable("id") Long id, @Valid @RequestBody Project project){
        projectService.uploadProject(id,project);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public void updateProject(@PathVariable("id") Long id, @Valid @RequestBody Project project){
        projectService.updateProject(id,project);
    }

    @RequestMapping(value = "/points/{id}/{points}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public void evaluateProject(@PathVariable("id") Long id, @PathVariable("points") int points){
        projectService.evaluateProject(id,points);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public Project deleteProjectById(@PathVariable("id") Long id){
        return projectService.deleteProjectById(id);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public List<Project> getAllProjectsFromStudent(@PathVariable("id") Long id){
        return projectService.getAllProjectsFromStudent(id);
    }

    @RequestMapping(value = "/student/{sId}/course/{cId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public Project getProjectByStudentAndCourse(@PathVariable("sId") Long studentId, @PathVariable("cId") Long courseId){
        return projectService.getProjectByStudentAndCourse(studentId,courseId);
    }

}
