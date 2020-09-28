package mk.ukim.finki.seminar.FinkiSW.Repository;

import mk.ukim.finki.seminar.FinkiSW.Model.Template;

import java.util.List;

public interface TemplateRepository {

    List<Template> getAllTemplates();

    Template getTemplateById(Long id);

    Template createTemplate(Template template);

    Template editTemplateById(Long id, Template template);

    Template deleteTemplateById(Long id);

}
