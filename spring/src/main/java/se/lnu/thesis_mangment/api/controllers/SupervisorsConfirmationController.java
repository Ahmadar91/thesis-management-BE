package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.model.SupervisorsConfirmation;
import se.lnu.thesis_mangment.model.SupervisorsConfirmationInput;
import se.lnu.thesis_mangment.services.SupervisorsConfirmationServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/supervisor-confirmation")
public class SupervisorsConfirmationController extends Controller
{
    @Autowired
    private SupervisorsConfirmationServices services;
    private static final String CONFIRMATION = "confirmation";

    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid SupervisorsConfirmationInput input)
    {
        return response(new ResponseArgument<>(CONFIRMATION, services.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid SupervisorsConfirmationInput input)
    {

        SupervisorsConfirmation supervisorsConfirmation = getSupervisorsConfirmationFromInput(input);
        services.add(supervisorsConfirmation);
        return response(new ResponseArgument<>(CONFIRMATION, supervisorsConfirmation));
    }

    // need improve
    private SupervisorsConfirmation getSupervisorsConfirmationFromInput(SupervisorsConfirmationInput input)
    {
        SupervisorsConfirmation supervisorsConfirmation = new SupervisorsConfirmation();
        supervisorsConfirmation.setConfirmed(input.getConfirmed());
        supervisorsConfirmation.setProjectPlanId(input.getProjectPlanId());
        supervisorsConfirmation.setStudentId(input.getStudentId());
        supervisorsConfirmation.setSupervisorId(input.getSupervisorId());
        supervisorsConfirmation.setId(input.getId());
        supervisorsConfirmation.setDeleted(input.getDeleted());
        return supervisorsConfirmation;
    }

}
