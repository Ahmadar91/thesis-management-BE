package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.services.UserServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/user")
public class UserController extends Controller
{
    @Autowired
    private UserServices userService;

    @RequestMapping("/login")
    public HashMap<String, Object> login(@Valid UsersInput input) throws IllegalAccessException
    {
        if (!input.validatePassword())
        {
            throw new IllegalAccessException();
        }
        return response(new ResponseArgument<>("user", userService.get(input)));
    }

    @RequestMapping("/get")
    public HashMap<String, Object> get(@Valid UsersInput input)
    {
        return response(new ResponseArgument<>("user", userService.get(input)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Transactional
    public HashMap<String, Object> add(@Valid UsersInput input)
    {
        User user = setUser(input);
        userService.add(user);
        return response(new ResponseArgument<>("user", user));
    }

    private User setUser(UsersInput input)
    {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setRoleId(input.getRoleId());
        user.setEmail(input.getEmail());
        user.setLastName(input.getEmail());
        return user;
    }

}
