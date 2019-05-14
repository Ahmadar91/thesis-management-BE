package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.LoginInput;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.services.UserServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends Controller
{
    @Autowired
    private UserServices userService;

    @RequestMapping("/get")
    public HashMap<String, Object> get(@Valid LoginInput input)
    {
        return response(new ResponseArgument<>("User is", userService.get(input)));
    }

    @RequestMapping("/add")
    @Transactional
    public HashMap<String, Object> add(@Valid LoginInput input)
    {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setRoleId(input.getRoleId());

        userService.add(user);
        return response(new ResponseArgument<>("User is", user));
    }

//    @RequestMapping("/signUp/{id}")
//    public void signUp(@RequestBody String firstName, @RequestBody String lastName, @RequestBody String email, @RequestBody String password)
//    {
//
//    }
//
//    @RequestMapping("/signIn")
//    public void signIn()
//    {
//
//    }
//
//    @RequestMapping("/signOut")
//    public void signOut()
//    {
//
//    }

}
