package mk.ukim.finki.seminar.FinkiSW.Service;

import mk.ukim.finki.seminar.FinkiSW.Model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    List<Project> getAllProjectsByCourse(Long id);

    Project getProjectById(Long id);

    Project createProject(Project project);

    Project editProjectById(Long id, Project project);

    Project deleteProjectById(Long id);

    List<Project> getAllProjectsFromStudent(Long id);

    Project getProjectByStudentAndCourse(Long studentId, Long courseId);

    void setFeedback(Long id, int state, Project feedback);

    void uploadProject(Long id, Project project);

    void updateProject(Long id, Project project);

    void evaluateProject(Long id, int points);
}
