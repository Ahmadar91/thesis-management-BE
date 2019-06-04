package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.services.UserServices;

import javax.validation.Valid;
import java.util.Map;

/**
 * The type Login controller.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/auth/")
public class LoginController extends Controller
{
    private static final String USER = "user";

    @Autowired
    private UserServices userService;

    /**
     * Login map.
     *
     * @param input the input
     * @return the map
     * @throws IllegalAccessException the illegal access exception
     */
    @RequestMapping("/login")
    public Map<String, Object> login(@Valid UsersDTO input) throws IllegalAccessException
    {
        if (!input.validatePassword())
        {
            throw new IllegalAccessException();
        }


        return response(new ResponseArgument<>(USER, userService.get(input)));
    }

    /**
     * Get map.
     *
     * @param input the input
     * @return the map
     */
    @GetMapping("/get")
    public Map<String, Object> get(@Valid UsersDTO input)
    {
        return response(new ResponseArgument<>(USER, userService.get(input)));
    }

    /**
     * Update confirmation map.
     *
     * @param input the input
     * @return the map
     */
    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateConfirmation(@Valid UsersDTO input)
    {
        UsersDTO dInput = new UsersDTO();
        dInput.setId(input.getId());
        User user = getById(dInput);
        if (input.getFirstName() != null)
        {
            input.setFirstName(input.getFirstName());
        }
        user.setLastName(input.getLastName());
        user.setUsername((input.getUsername()));
        user.setEmail((input.getEmail()));
        user.setRoleId((input.getRoleId()));
        userService.update(user);
        return response(new ResponseArgument<>(USER, user));
    }

    /**
     * Gets by id.
     *
     * @param input the input
     * @return the by id
     */
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
