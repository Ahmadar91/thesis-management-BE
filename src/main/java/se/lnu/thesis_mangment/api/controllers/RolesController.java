package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.Role;
import se.lnu.thesis_mangment.services.RolesService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/roles")
public class RolesController extends Controller
{

    @Autowired
    private RolesService rolesService;

    @RequestMapping("")
    public HashMap<String, Object> getRoles()
    {
        return response(new ResponseArgument<>("Roles are", rolesService.get()));
    }

}
