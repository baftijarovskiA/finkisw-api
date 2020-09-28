package mk.ukim.finki.seminar.FinkiSW.Service;

import mk.ukim.finki.seminar.FinkiSW.Model.Template;

import java.util.List;

public interface TemplateService {

    List<Template> getAllTemplates();

    Template getTemplateById(Long id);

    Template createTemplate(Template template);

    Template editTemplateById(Long id, Template template);

    Template deleteTemplateById(Long id);

}
