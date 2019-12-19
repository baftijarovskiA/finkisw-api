package mk.ukim.finki.seminar.FinkiSW.Model;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "app_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "studyYear")
    private String studyYear;

    @Column(name = "info", length = 5000)
    private String info;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "course_teacher", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> teachers;

    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> students;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStudyYear() { return studyYear; }

    public void setStudyYear(String studyYear) { this.studyYear = studyYear; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<User> getTeachers() { return teachers; }

    public void setTeachers(Set<User> teachers) { this.teachers = teachers; }

    public Set<User> getStudents() { return students; }

    public void setStudents(Set<User> students) { this.students = students; }
}
