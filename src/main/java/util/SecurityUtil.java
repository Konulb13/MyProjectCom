package util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class SecurityUtil {
    private static final String SALT = "salt";        //singleton ?

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    @Bean
    public static String randomPassword() {
        String SALTCHARS = "ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
