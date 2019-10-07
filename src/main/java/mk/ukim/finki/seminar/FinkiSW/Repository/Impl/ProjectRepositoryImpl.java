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
        p.setFileLocation(project.getFileLocation());
        repository.save(p);

        return p;
    }

    @Override
    public Project deleteProjectById(Long id) {
        Project p = repository.findById(id).get();
        repository.delete(p);
        return p;
    }
}
