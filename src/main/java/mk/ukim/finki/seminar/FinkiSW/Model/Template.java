package mk.ukim.finki.seminar.FinkiSW.Model;

import javax.persistence.*;

@Entity
@Table(name = "app_template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "repository")
    private String repository;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRepository() { return repository; }

    public void setRepository(String repository) { this.repository = repository; }
}
