package mk.ukim.finki.seminar.FinkiSW.Repository;

import mk.ukim.finki.seminar.FinkiSW.Model.Project;

import java.util.List;

public interface ProjectRepository {

    List<Project> getAllProjects();

    List<Project> getAllProjectsByCourse(Long id);

    Project getProjectById(Long id);

    Project createProject(Project project);

    Project editProjectById(Long id, Project project);

    Project deleteProjectById(Long id);

}