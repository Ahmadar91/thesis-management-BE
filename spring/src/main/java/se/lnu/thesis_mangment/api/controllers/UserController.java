package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.services.UserServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/user")
public class UserController extends Controller
{
    private static final String USER = "user";

    @Autowired
    private UserServices userService;

    @RequestMapping("/login")
    public Map<String, Object> login(@Valid UsersDTO input) throws IllegalAccessException
    {
        if (!input.validatePassword())
        {
            throw new IllegalAccessException();
        }
        return response(new ResponseArgument<>(USER, userService.get(input)));
    }

    @GetMapping("/get")
    public Map<String, Object> get(@Valid UsersDTO input)
    {
        return response(new ResponseArgument<>(USER, userService.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid UsersDTO input)
    {
        User user = setUser(input);
        userService.add(user);
        return response(new ResponseArgument<>("user", user));
    }

    private User setUser(UsersDTO input)
    {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setPassword(input.getPassword());
        user.setRoleId(input.getRoleId());
        user.setEmail(input.getEmail());
        user.setLastName(input.getEmail());
        return user;
    }


    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateConfirmation(@Valid UsersDTO input)
    {
        UsersDTO dInput = new UsersDTO();
        dInput.setId(input.getId());
        User user = getById(dInput);
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setUsername((input.getUsername()));
        user.setEmail((input.getEmail()));
        user.setRoleId((input.getRoleId()));
        userService.update(user);
        return response(new ResponseArgument<>(USER, user));
    }

    public User getById(UsersDTO input)
    {
        User user = userService.get(input);
        if (user == null)
        {
            throw new ResourceNotFoundException("user not found");
        }
        return user;
    }

}
