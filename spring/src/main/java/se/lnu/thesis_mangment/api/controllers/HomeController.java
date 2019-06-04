package se.lnu.thesis_mangment.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Home controller.
 */
@Controller
public class HomeController
{
    /**
     * Home string.
     *
     * @return the string
     */
    @GetMapping(value = {"", "/", "/home"})
    public String home()
    {
        return "home";
    }
}
