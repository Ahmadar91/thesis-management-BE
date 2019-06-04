package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Feedbacks;
import se.lnu.thesis_mangment.model.FeedbacksDTO;
import se.lnu.thesis_mangment.repositories.FeedbacksRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Feedbacks services.
 */
@Service
public class FeedbacksServices
{
    @Autowired
    private FeedbacksRepository repository;

    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Feedbacks> get(FeedbacksDTO input)
    {
        return repository.get(input);
    }


    /**
     * Add.
     *
     * @param document the document
     */
    @Transactional
    public void add(Feedbacks document)
    {
        repository.add(document);
    }

    /**
     * Delete list.
     *
     * @param list the list
     * @return the list
     */
    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Feedbacks.class);
        return list;
    }

    /**
     * Update.
     *
     * @param item the item
     */
    public void update(Feedbacks item)
    {
        repository.update(item);
    }
}
