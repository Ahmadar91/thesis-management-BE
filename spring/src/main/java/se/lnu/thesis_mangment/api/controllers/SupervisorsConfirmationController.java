package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.SupervisorsConfirmation;
import se.lnu.thesis_mangment.model.SupervisorsConfirmationInput;
import se.lnu.thesis_mangment.services.SupervisorsConfirmationServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
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

    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateConfirmation(@Valid SupervisorsConfirmationInput input) {
        SupervisorsConfirmationInput dInput = new SupervisorsConfirmationInput();
        dInput.setId(input.getId());
        SupervisorsConfirmation supervisorsConfirmation = getById(dInput);


        supervisorsConfirmation.setConfirmed(input.getConfirmed());
        services.update(supervisorsConfirmation);
        return response(new ResponseArgument<>(CONFIRMATION, supervisorsConfirmation));
    }

    public SupervisorsConfirmation getById(@Valid SupervisorsConfirmationInput input) {
        List<SupervisorsConfirmation> list = services.get(input);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("confirmation not found");
        }
        return list.get(0);
    }


    // need improve
    private SupervisorsConfirmation getSupervisorsConfirmationFromInput(SupervisorsConfirmationInput input)
    {
        SupervisorsConfirmation supervisorsConfirmation = new SupervisorsConfirmation();
        supervisorsConfirmation.setConfirmed(input.getConfirmed());
        supervisorsConfirmation.setProjectPlanId(input.getProjectPlanId());
        supervisorsConfirmation.setStudentId(input.getStudentId());
        supervisorsConfirmation.setSupervisorId(input.getSupervisorId());
        return supervisorsConfirmation;
    }



}
