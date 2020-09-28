package mk.ukim.finki.seminar.FinkiSW.Service.Impl;

import mk.ukim.finki.seminar.FinkiSW.Model.Project;
import mk.ukim.finki.seminar.FinkiSW.Repository.Impl.ProjectRepositoryImpl;
import mk.ukim.finki.seminar.FinkiSW.Service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepositoryImpl repository;

    public ProjectServiceImpl(ProjectRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAllProjects() {
        return repository.getAllProjects();
    }

    @Override
    public List<Project> getAllProjectsByCourse(Long id) {
        return repository.getAllProjectsByCourse(id);
    }

    @Override
    public Project getProjectById(Long id) {
        return repository.getProjectById(id);
    }

    @Override
    public Project createProject(Project project) {
        return repository.createProject(project);
    }

    @Override
    public Project editProjectById(Long id, Project project) {
        return repository.editProjectById(id,project);
    }

    @Override
    public Project deleteProjectById(Long id) {
        return repository.deleteProjectById(id);
    }

    @Override
    public List<Project> getAllProjectsFromStudent(Long id) {
        return repository.getAllProjectsFromStudent(id);
    }

    @Override
    public Project getProjectByStudentAndCourse(Long studentId, Long courseId) {
        return repository.getProjectByStudentAndCourse(studentId, courseId);
    }

    @Override
    public void setFeedback(Long id, int state, Project feedback) {
        repository.setFeedback(id,state,feedback);
    }

    @Override
    public void uploadProject(Long id, Project project) {
        repository.uploadProject(id,project);
    }

    @Override
    public void updateProject(Long id, Project project) {
        repository.updateProject(id, project);
    }

    @Override
    public void evaluateProject(Long id, int points) {
        repository.evaluateProject(id,points);
    }
}
