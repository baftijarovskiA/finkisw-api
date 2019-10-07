package mk.ukim.finki.seminar.FinkiSW.Model;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "app_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "feedback", length = 2000)
    private String feedback;

    private String postedDate;
    private String editedDate;

    @Column(name = "filelocation")
    private String fileLocation;

    @OneToOne
    private Course course;

    @OneToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(String editedDate) {
        this.editedDate = editedDate;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}