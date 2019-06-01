package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Feedbacks;
import se.lnu.thesis_mangment.model.FeedbacksDTO;
import se.lnu.thesis_mangment.repositories.FeedbacksRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FeedbacksServices
{
    @Autowired
    private FeedbacksRepository repository;

    public List<Feedbacks> get(FeedbacksDTO input)
    {
        return repository.get(input);
    }


    @Transactional
    public void add(Feedbacks document)
    {
        repository.add(document);
    }

    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Feedbacks.class);
        return list;
    }

    public void update(Feedbacks item)
    {
        repository.update(item);
    }
}
