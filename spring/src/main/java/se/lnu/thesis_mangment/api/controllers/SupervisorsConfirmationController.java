package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid SupervisorsConfirmationInput input)
    {

        SupervisorsConfirmation supervisorsConfirmation = getSupervisorsConfirmationFromInput(input);
        services.add(supervisorsConfirmation);
        return response(new ResponseArgument<>("document", supervisorsConfirmation));
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
