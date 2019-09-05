package mk.ukim.finki.seminar.FinkiSW;

import mk.ukim.finki.seminar.FinkiSW.Auth.controller.AccountController;
import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class FinkiSwApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinkiSwApplication.class, args);
	}
}
