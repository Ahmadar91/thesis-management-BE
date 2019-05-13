package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.*;
import se.lnu.thesis_mangment.repositories.DocumentRepository;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import java.util.List;

@Service
public class DocumentService
{
    @Autowired
    private DocumentRepository repository;

    public List<Document> get(DocumentInput input)
    {
        return repository.get(input);
    }

    public Long count()
    {
        return repository.count(Document.class);
    }

    public Document create(Document item)
    {
        return repository.save(item);
    }

    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Document.class);
        return list;
    }


}
