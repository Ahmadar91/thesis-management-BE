package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Biddings;
import se.lnu.thesis_mangment.model.BiddingsDTO;
import se.lnu.thesis_mangment.repositories.BiddingsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BiddingsServices
{
    @Autowired
    private BiddingsRepository repository;

    public List<Biddings> get(BiddingsDTO input)
    {
        return repository.get(input);
    }


    @Transactional
    public void add(Biddings document)
    {
        repository.add(document);
    }

    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Biddings.class);
        return list;
    }

    public void update(Biddings item)
    {
        repository.update(item);
    }
}
