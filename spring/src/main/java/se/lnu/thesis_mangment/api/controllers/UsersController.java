package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.services.UsersServices;

import javax.validation.Valid;
import java.util.Map;

/**
 * The type Users controller.
 */
@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController extends Controller
{
    @Autowired
    private UsersServices usersService;

    /**
     * Get map.
     *
     * @param input the input
     * @return the map
     */
    @RequestMapping("/get")
    public Map<String, Object> get(@Valid UsersDTO input)
    {
        return response(new ResponseArgument<>("users", usersService.get(input)));
    }

}
