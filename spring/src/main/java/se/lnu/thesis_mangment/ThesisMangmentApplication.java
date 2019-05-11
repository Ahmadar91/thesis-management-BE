package se.lnu.thesis_mangment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ThesisMangmentApplication extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
        SpringApplication.run(ThesisMangmentApplication.class, args);
    }

}