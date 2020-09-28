package mk.ukim.finki.seminar.FinkiSW.Repository.Impl;

import mk.ukim.finki.seminar.FinkiSW.Model.Template;
import mk.ukim.finki.seminar.FinkiSW.Repository.JpaRepository.TemplateJpaRepository;
import mk.ukim.finki.seminar.FinkiSW.Repository.TemplateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

    private TemplateJpaRepository repository;

    public TemplateRepositoryImpl(TemplateJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Template> getAllTemplates() {
        return repository.findAll();
    }

    @Override
    public Template getTemplateById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Template createTemplate(Template template) {
        repository.save(template);
        return template;
    }

    @Override
    public Template editTemplateById(Long id, Template template) {
        Template t = repository.findById(id).get();
        t.setName(template.getName());
        t.setRepository(template.getRepository());
        repository.save(t);
        return t;
    }

    @Override
    public Template deleteTemplateById(Long id) {
        Template t = repository.findById(id).get();
        repository.delete(t);
        return t;
    }
}
