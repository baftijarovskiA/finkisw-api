package mk.ukim.finki.seminar.FinkiSW.Auth.controller;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.Role;
import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.Auth.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private GenericService genericService;

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){  return genericService.findAllUsers(); }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public User registerNewUser(@Valid @RequestBody User user) throws IOException, MessagingException {
        return genericService.registerNewUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public User removeUser(@PathVariable("id") Long id) throws IOException, MessagingException {
        return genericService.removeUser(id);
    }

    @RequestMapping(value ="/roles", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<Role> getRoles(){
        return genericService.findAllRoles();
    }
}
