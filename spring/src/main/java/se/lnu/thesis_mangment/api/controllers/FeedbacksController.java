package se.lnu.thesis_mangment.api.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.Feedbacks;
import se.lnu.thesis_mangment.model.FeedbacksDTO;
import se.lnu.thesis_mangment.services.FeedbacksServices;
import se.lnu.thesis_mangment.services.FileService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;


/**
 * The type Feedbacks controller.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/feedbacks")
public class FeedbacksController extends Controller
{
    private static final String FEEDBACKS = "feedbacks";
    @Autowired
    private FeedbacksServices feedbacksServices;
    @Autowired
    private FileService fileService;

    /**
     * Get map.
     *
     * @param input the input
     * @return the map
     */
    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid FeedbacksDTO input)
    {
        return response(new ResponseArgument<>(FEEDBACKS, feedbacksServices.get(input)));
    }

    /**
     * Add map.
     *
     * @param input the input
     * @return the map
     * @throws IOException the io exception
     */
    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid FeedbacksDTO input) throws IOException
    {
        Feedbacks feedbacks = getFeedbacksFromInput(input);
        feedbacksServices.add(feedbacks);

        // Save the file
        fileService.saveFeedback(input.getFile(), feedbacks.getId().toString() + ".pdf");

        return response(new ResponseArgument<>(FEEDBACKS, feedbacks));
    }


    /**
     * Download resource.
     *
     * @param input the input
     * @return the resource
     * @throws IOException       the io exception
     * @throws NotFoundException the not found exception
     */
    @GetMapping(value = "/download", produces = APPLICATION_PDF_VALUE)
    public Resource download(@Valid FeedbacksDTO input) throws IOException, NotFoundException
    {
        return fileService.getFeedback(input.getId() + ".pdf");
    }


    /**
     * Update feedbacks map.
     *
     * @param input the input
     * @return the map
     */
    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateFeedbacks(@Valid FeedbacksDTO input)
    {
        FeedbacksDTO dInput = new FeedbacksDTO();
        dInput.setId(input.getId());
        Feedbacks feedbacks = getById(dInput);
        updateFeedbacks(feedbacks, input);
        return response(new ResponseArgument<>(FEEDBACKS, feedbacks));
    }

    /**
     * Gets by id.
     *
     * @param input the input
     * @return the by id
     */
    public Feedbacks getById(@Valid FeedbacksDTO input)
    {
        List<Feedbacks> feedbacks = feedbacksServices.get(input);
        if (feedbacks.isEmpty())
        {
            throw new ResourceNotFoundException("Feedbacks not found");
        }
        return feedbacks.get(0);
    }

    /**
     * Delete map.
     *
     * @param input the input
     * @return the map
     */
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
        feedbacks.setAuthorId(input.getAuthorId());
        feedbacks.setDeleted(input.getDeleted());
        feedbacks.setDocument(input.getDocument());
        return feedbacks;

    }

    private void updateFeedbacks(Feedbacks feedbacks, FeedbacksDTO input)
    {
        if (input.getAuthorId() != 0)
        {
            feedbacks.setAuthorId(input.getAuthorId());
        }
        if (input.getDocument() != null)
        {
            feedbacks.setDocument(input.getDocument());
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
