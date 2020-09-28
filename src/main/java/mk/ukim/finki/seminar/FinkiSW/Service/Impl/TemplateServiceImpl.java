package mk.ukim.finki.seminar.FinkiSW.Service.Impl;

import mk.ukim.finki.seminar.FinkiSW.Model.Template;
import mk.ukim.finki.seminar.FinkiSW.Repository.Impl.TemplateRepositoryImpl;
import mk.ukim.finki.seminar.FinkiSW.Service.TemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    private TemplateRepositoryImpl repository;

    public TemplateServiceImpl(TemplateRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Template> getAllTemplates() {
        return repository.getAllTemplates();
    }

    @Override
    public Template getTemplateById(Long id) {
        return repository.getTemplateById(id);
    }

    @Override
    public Template createTemplate(Template template) {
        return repository.createTemplate(template);
    }

    @Override
    public Template editTemplateById(Long id, Template template) {
        return repository.editTemplateById(id, template);
    }

    @Override
    public Template deleteTemplateById(Long id) {
        return repository.deleteTemplateById(id);
    }
}
