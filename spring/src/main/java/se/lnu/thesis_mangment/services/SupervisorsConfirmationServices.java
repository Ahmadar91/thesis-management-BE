package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.SupervisorsConfirmation;
import se.lnu.thesis_mangment.model.SupervisorsConfirmationDTO;
import se.lnu.thesis_mangment.repositories.SupervisorsConfirmationRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Supervisors confirmation services.
 */
@Service
public class SupervisorsConfirmationServices
{
    @Autowired
    private SupervisorsConfirmationRepository repository;

    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<SupervisorsConfirmation> get(SupervisorsConfirmationDTO input)
    {
        return repository.get(input);
    }

    /**
     * Count long.
     *
     * @return the long
     */
    public Long count()
    {
        return repository.count(SupervisorsConfirmation.class);
    }

    /**
     * Add.
     *
     * @param input the input
     */
    @Transactional
    public void add(SupervisorsConfirmation input)
    {
        repository.add(input);
    }

    /**
     * Delete list.
     *
     * @param list the list
     * @return the list
     */
    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, SupervisorsConfirmation.class);
        return list;
    }

    /**
     * Update.
     *
     * @param item the item
     */
    public void update(SupervisorsConfirmation item) {
        repository.update(item);
    }
}
