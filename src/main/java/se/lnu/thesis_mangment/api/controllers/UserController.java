package se.lnu.thesis_mangment.api.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{

    @RequestMapping("/signUp")
    public void signUp(@RequestBody String firstName, @RequestBody String lastName, @RequestBody String email, @RequestBody String password)
    {

    }

    @RequestMapping("/signIn")
    public void signIn()
    {

    }

    @RequestMapping("/signOut")
    public void signOut()
    {

    }
}
