package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.Submission;
import se.lnu.thesis_mangment.model.SubmissionDTO;
import se.lnu.thesis_mangment.services.SubmissionServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/submission")
public class SubmissionController extends Controller
{
    private static final String SUBMISSION = "submission";
    @Autowired
    private SubmissionServices submissionServices;


    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid SubmissionDTO input)
    {
        return response(new ResponseArgument<>(SUBMISSION, submissionServices.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid SubmissionDTO input) throws IOException
    {
        Submission submission = getSubmissionFromInput(input);
        submissionServices.add(submission);
        return response(new ResponseArgument<>(SUBMISSION, submission));
    }


    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateFeedbacks(@Valid SubmissionDTO input)
    {
        SubmissionDTO dInput = new SubmissionDTO();
        dInput.setId(input.getId());
        Submission submission = getById(dInput);
        updateFeedbacks(submission, input);
        return response(new ResponseArgument<>(SUBMISSION, submission));
    }

    public Submission getById(@Valid SubmissionDTO input)
    {
        List<Submission> submissions = submissionServices.get(input);
        if (submissions.isEmpty())
        {
            throw new ResourceNotFoundException("Submissions not found");
        }
        return submissions.get(0);
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public Map<String, Object> delete(@Valid SubmissionDTO input)
    {
        Submission newSubmission = getById(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        submissionServices.delete(list);
        return response(new ResponseArgument<>(SUBMISSION, newSubmission));
    }

    private Submission getSubmissionFromInput(SubmissionDTO input)
    {
        Submission submission = new Submission();
        submission.setId(input.getId());
        submission.setDeadline(input.getDeadline());
        submission.setStep(input.getStep());
        submission.setTitle(input.getTitle());
        return submission;

    }

    private void updateFeedbacks(Submission submission, SubmissionDTO input)
    {
        if (input.getId() != 0)
        {
            submission.setId(input.getId());
        }
        if (input.getTitle() != null)
        {
            submission.setTitle(input.getTitle());
        }
        if (input.getDeadline() != null)
        {
            submission.setDeadline(input.getDeadline());
        }
        if (input.getStep() >= 0)
        {
            submission.setStep(input.getStep());
        }
        if (input.getId() >= 0)
        {
            submission.setId(input.getId());
        }
        submissionServices.update(submission);
    }

}
