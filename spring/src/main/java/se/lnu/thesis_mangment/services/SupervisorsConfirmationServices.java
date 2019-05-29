package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.SupervisorsConfirmation;
import se.lnu.thesis_mangment.model.SupervisorsConfirmationInput;
import se.lnu.thesis_mangment.repositories.SupervisorsConfirmationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SupervisorsConfirmationServices
{
    @Autowired
    private SupervisorsConfirmationRepository repository;

    public List<SupervisorsConfirmation> get(SupervisorsConfirmationInput input)
    {
        return repository.get(input);
    }

    public Long count()
    {
        return repository.count(SupervisorsConfirmation.class);
    }

    @Transactional
    public void add(SupervisorsConfirmation input)
    {
        repository.add(input);
    }

    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, SupervisorsConfirmation.class);
        return list;
    }

    public void update(SupervisorsConfirmation item) {
        repository.update(item);
    }
}
