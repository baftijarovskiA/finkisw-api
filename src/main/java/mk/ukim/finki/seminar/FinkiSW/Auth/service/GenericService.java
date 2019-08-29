package mk.ukim.finki.seminar.FinkiSW.Auth.service;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.Role;
import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface GenericService {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAllUsers();

    List<Role> findAllRoles();

    User registerNewUser(User user) throws IOException, MessagingException;

    User removeUser(Long id) throws IOException, MessagingException;

    User editUser(Long id, User user) throws IOException, MessagingException;

}
