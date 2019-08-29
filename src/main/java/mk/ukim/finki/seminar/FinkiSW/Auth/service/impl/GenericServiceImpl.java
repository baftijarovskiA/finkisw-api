package mk.ukim.finki.seminar.FinkiSW.Auth.service.impl;

import mk.ukim.finki.seminar.FinkiSW.Auth.controller.EmailController;
import mk.ukim.finki.seminar.FinkiSW.Auth.domain.Role;
import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.Auth.repository.RoleJpaRepository;
import mk.ukim.finki.seminar.FinkiSW.Auth.repository.UserJpaRepository;
import mk.ukim.finki.seminar.FinkiSW.Auth.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private RoleJpaRepository roleJpaRepository;

    @Autowired
    private EmailController emailController;

    @Override
    public User findByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userJpaRepository.findAll();
    }

    @Override
    public List<Role> findAllRoles() {
        return (List<Role>) roleJpaRepository.findAll();
    }

    @Override
    public User registerNewUser(User user) throws IOException, MessagingException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = pwgenerator();
        emailController.sendEmail(user.getEmail(), user.getUsername(), password,false);
        user.setPassword(passwordEncoder.encode(password));
        userJpaRepository.save(user);
        return user;
    }

    @Override
    public User removeUser(Long id) throws IOException, MessagingException {
        User user = userJpaRepository.findById(id).get();
        emailController.sendEmail(user.getEmail(), user.getUsername(), user.getPassword(), true);
        userJpaRepository.delete(user);
        return user;
    }

    private String pwgenerator() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }
}
