package mk.ukim.finki.seminar.FinkiSW;

import mk.ukim.finki.seminar.FinkiSW.Auth.controller.AccountController;
import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import mk.ukim.finki.seminar.FinkiSW.FileUpload.property.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class FinkiSwApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinkiSwApplication.class, args);
	}
}
