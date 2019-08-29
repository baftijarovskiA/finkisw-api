package mk.ukim.finki.seminar.FinkiSW.Auth.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

public class PasswordEncoder {

    public static String pwgenerator() {

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

    public static void main(String[] args) {
        String password = "admpass";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(password));
//        System.out.println(pwgenerator());
    }
}
