package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Biddings;
import se.lnu.thesis_mangment.model.BiddingsDTO;
import se.lnu.thesis_mangment.repositories.BiddingsRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Biddings services.
 */
@Service
public class BiddingsServices
{
    @Autowired
    private BiddingsRepository repository;

    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Biddings> get(BiddingsDTO input)
    {
        return repository.get(input);
    }


    /**
     * Add.
     *
     * @param document the document
     */
    @Transactional
    public void add(Biddings document)
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
        repository.delete(list, Biddings.class);
        return list;
    }

    /**
     * Update.
     *
     * @param item the item
     */
    public void update(Biddings item)
    {
        repository.update(item);
    }
}
