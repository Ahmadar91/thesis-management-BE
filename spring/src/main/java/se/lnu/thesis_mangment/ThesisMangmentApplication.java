package se.lnu.thesis_mangment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * The type Thesis mangment application.
 */
@SpringBootApplication
public class ThesisMangmentApplication extends SpringBootServletInitializer
{

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ThesisMangmentApplication.class, args);
    }


    /**
     * Password encoder b crypt password encoder.
     *
     * @return the b crypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}