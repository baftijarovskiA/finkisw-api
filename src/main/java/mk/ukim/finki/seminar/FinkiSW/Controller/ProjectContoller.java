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
    public Project editProjectById(@PathVariable("id") Long id,@Valid @RequestBody Project project){
        return projectService.editProjectById(id,project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('STUDENT_USER') or hasAuthority('ADMIN_USER')")
    public Project deleteProjectById(@PathVariable("id") Long id){
        return projectService.deleteProjectById(id);
    }

}
