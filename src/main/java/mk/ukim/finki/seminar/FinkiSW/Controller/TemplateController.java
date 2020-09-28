package mk.ukim.finki.seminar.FinkiSW.Controller;

import mk.ukim.finki.seminar.FinkiSW.Model.Project;
import mk.ukim.finki.seminar.FinkiSW.Model.Template;
import mk.ukim.finki.seminar.FinkiSW.Service.Impl.TemplateServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private TemplateServiceImpl templateService;

    public TemplateController(TemplateServiceImpl templateService) {
        this.templateService = templateService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER') or hasAuthority('STUDENT_USER')")
    public List<Template> getAllTemplates(){
        return templateService.getAllTemplates();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public Template getTemplateById(@PathVariable("id") Long id){
        return templateService.getTemplateById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public Template createTemplate(@Valid @RequestBody Template template){
        return templateService.createTemplate(template);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public Template editTemplateById(@PathVariable("id") Long id,@Valid @RequestBody Template template){
        return templateService.editTemplateById(id, template);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('TEACHER_USER') or hasAuthority('ADMIN_USER')")
    public Template deleteTemplateById(@PathVariable("id") Long id){
        return templateService.deleteTemplateById(id);
    }


}
