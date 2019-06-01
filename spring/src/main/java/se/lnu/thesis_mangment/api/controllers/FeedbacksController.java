package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.Feedbacks;
import se.lnu.thesis_mangment.model.FeedbacksDTO;
import se.lnu.thesis_mangment.services.FeedbacksServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/feedbacks")
public class FeedbacksController extends Controller
{
    private static final String FEEDBACKS = "feedbacks";
    @Autowired
    private FeedbacksServices feedbacksServices;


    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid FeedbacksDTO input)
    {
        return response(new ResponseArgument<>(FEEDBACKS, feedbacksServices.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid FeedbacksDTO input) throws IOException
    {
        Feedbacks feedbacks = getFeedbacksFromInput(input);
        feedbacksServices.add(feedbacks);
        return response(new ResponseArgument<>(FEEDBACKS, feedbacks));
    }


    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateFeedbacks(@Valid FeedbacksDTO input)
    {
        FeedbacksDTO dInput = new FeedbacksDTO();
        dInput.setId(input.getId());
        Feedbacks feedbacks = getById(dInput);
        updateFeedbacks(feedbacks, input);
        return response(new ResponseArgument<>(FEEDBACKS, feedbacks));
    }

    public Feedbacks getById(@Valid FeedbacksDTO input)
    {
        List<Feedbacks> feedbacks = feedbacksServices.get(input);
        if (feedbacks.isEmpty())
        {
            throw new ResourceNotFoundException("Feedbacks not found");
        }
        return feedbacks.get(0);
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public Map<String, Object> delete(@Valid FeedbacksDTO input)
    {
        Feedbacks newFeedbacks = getById(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        feedbacksServices.delete(list);
        return response(new ResponseArgument<>(FEEDBACKS, newFeedbacks));
    }

    private Feedbacks getFeedbacksFromInput(FeedbacksDTO input)
    {
        Feedbacks feedbacks = new Feedbacks();
        feedbacks.setId(input.getId());
        feedbacks.setStudentId(input.getStudentId());
        feedbacks.setDocumentId(input.getDocumentId());
        feedbacks.setDeleted(input.getDeleted());
        return feedbacks;

    }

    private void updateFeedbacks(Feedbacks feedbacks, FeedbacksDTO input)
    {
        if (input.getStudentId() != 0)
        {
            feedbacks.setStudentId(input.getStudentId());
        }
        if (input.getDocumentId() >= 0)
        {
            feedbacks.setDocumentId(input.getDocumentId());
        }
        if (input.getDeleted() >= 0)
        {
            feedbacks.setDeleted(input.getDeleted());
        }
        if (input.getId() >= 0)
        {
            feedbacks.setId(input.getId());
        }
        feedbacksServices.update(feedbacks);
    }

}
