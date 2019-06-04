package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.services.RolesService;

import javax.validation.Valid;
import java.util.Map;

/**
 * The type Roles controller.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/roles")
public class RolesController extends Controller
{

    @Autowired
    private RolesService rolesService;

    /**
     * Gets roles.
     *
     * @param input the input
     * @return the roles
     */
    @RequestMapping("")
    public Map<String, Object> getRoles(@Valid UsersDTO input)
    {
        return response(new ResponseArgument<>("role", rolesService.get()));
    }


    /**
     * Gets role.
     *
     * @param id the id
     * @return the role
     */
    @RequestMapping("{id}")
    public Map<String, Object> getRole(@PathVariable("id") long id)
    {
        return response(new ResponseArgument<>("role", rolesService.get()));
    }
}
