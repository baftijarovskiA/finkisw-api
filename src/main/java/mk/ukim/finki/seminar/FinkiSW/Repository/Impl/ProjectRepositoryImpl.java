package mk.ukim.finki.seminar.FinkiSW.Repository.Impl;

import mk.ukim.finki.seminar.FinkiSW.Model.Project;
import mk.ukim.finki.seminar.FinkiSW.Repository.JpaRepository.ProjectJpaRepository;
import mk.ukim.finki.seminar.FinkiSW.Repository.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private ProjectJpaRepository repository;

    public ProjectRepositoryImpl(ProjectJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public List<Project> getAllProjectsByCourse(Long id) {

        List<Project> projects = new ArrayList<>();
        for (Project p: repository.findAll()) {
            if(p.getCourse().getId().equals(id)){
                projects.add(p);
            }
        }
        return projects;
    }

    @Override
    public Project getProjectById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Project createProject(Project project) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        project.setPostedDate(formattedDateTime);
        project.setEditedDate(formattedDateTime);
        project.setStatus("Not reviewed");

        repository.save(project);
        return project;
    }

    @Override
    public Project editProjectById(Long id, Project project) {
        Project p = repository.findById(id).get();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        p.setEditedDate(formattedDateTime);
        p.setName(project.getName());
        p.setDescription(project.getDescription());
        p.setStatus("Not reviewed");
        repository.save(p);

        return p;
    }

    @Override
    public Project deleteProjectById(Long id) {
        Project p = repository.findById(id).get();
        p.setCourse(null);
        repository.save(p);
        repository.delete(p);
        return p;
    }

    @Override
    public List<Project> getAllProjectsFromStudent(Long id) {
        List<Project> projects = new ArrayList<>();
        for (Project project: repository.findAll()) {
            if(project.getUser().getId().equals(id)){
                projects.add(project);
            }
        }
        return projects;
    }

    @Override
    public Project getProjectByStudentAndCourse(Long studentId, Long courseId) {
        for (Project p: repository.findAll()) {
            if(p.getUser().getId().equals(studentId)){
                if(p.getCourse().getId().equals(courseId)){
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void setFeedback(Long id, int state, Project feedback) {
        Project project = repository.findById(id).get();
        if(state == 1) project.setStatus("Accepted");
        else project.setStatus("Rejected");
        project.setFeedback(feedback.getFeedback());
        repository.save(project);
    }

    @Override
    public void uploadProject(Long id, Project project) {
        Project p = repository.findById(id).get();
        p.setFileLocation(project.getFileLocation());
        repository.save(p);
    }

    @Override
    public void updateProject(Long id, Project project) {
        Project p = repository.findById(id).get();
        p.setFileLocation(project.getFileLocation());
        p.setFullName(project.getFullName());
        repository.save(p);
    }

    @Override
    public void evaluateProject(Long id, int points) {
        Project p = repository.findById(id).get();
        p.setPoints(points);
        p.setStatus("Graded");
        repository.save(p);
    }
}
