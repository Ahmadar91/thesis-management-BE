package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.Biddings;
import se.lnu.thesis_mangment.model.BiddingsDTO;
import se.lnu.thesis_mangment.services.BiddingsServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/biddings")
public class BiddingsController extends Controller
{
    private static final String Bidding = "bidding";
    @Autowired
    private BiddingsServices biddingsServices;


    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid BiddingsDTO input)
    {
        return response(new ResponseArgument<>(Bidding, biddingsServices.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid BiddingsDTO input) throws IOException
    {
        Biddings biddings = getBiddingsFromInput(input);
        biddingsServices.add(biddings);
        return response(new ResponseArgument<>(Bidding, biddings));
    }


    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateBiddings(@Valid BiddingsDTO input)
    {
        BiddingsDTO dInput = new BiddingsDTO();
        dInput.setId(input.getId());
        Biddings biddings = getById(dInput);
        updateBiddings(biddings, input);
        return response(new ResponseArgument<>(Bidding, biddings));
    }

    public Biddings getById(@Valid BiddingsDTO input)
    {
        List<Biddings> biddings = biddingsServices.get(input);
        if (biddings.isEmpty())
        {
            throw new ResourceNotFoundException("biddings not found");
        }
        return biddings.get(0);
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public Map<String, Object> delete(@Valid BiddingsDTO input)
    {
        Biddings newBiddings = getById(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        biddingsServices.delete(list);
        return response(new ResponseArgument<>(Bidding, newBiddings));
    }

    private Biddings getBiddingsFromInput(BiddingsDTO input)
    {
        Biddings biddings = new Biddings();
        biddings.setId(input.getId());
        biddings.setAssigned(input.getAssigned());
        biddings.setBiddingNumber(input.getBiddingNumber());
        biddings.setReaderId(input.getReaderId());
        biddings.setReportId(input.getReportId());
        return biddings;

    }

    private void updateBiddings(Biddings document, BiddingsDTO input)
    {
        if (input.getReaderId() != 0)
        {
            document.setReaderId(input.getReaderId());
        }
        if (input.getReportId() >= 0)
        {
            document.setReportId(input.getReportId());
        }
        if (input.getAssigned() >= 0)
        {
            document.setAssigned(input.getAssigned());
        }
        if (input.getBiddingNumber() >= 0)
        {
            document.setAssigned(input.getBiddingNumber());
        }
        biddingsServices.update(document);
    }

}
