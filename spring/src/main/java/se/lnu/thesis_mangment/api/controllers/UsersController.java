package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.services.UsersServices;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController extends Controller
{
    @Autowired
    private UsersServices usersService;

    @RequestMapping("/get")
    public HashMap<String, Object> get(@Valid UsersInput input)
    {
        return response(new ResponseArgument<>("users", usersService.get(input)));
    }

}
