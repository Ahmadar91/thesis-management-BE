package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.repositories.DocumentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentServices {
    @Autowired
    private DocumentRepository repository;

    public List<Document> get(DocumentInput input) {
        return repository.get(input);
    }

    public Long count() {
        return repository.count(Document.class);
    }

    @Transactional
    public void add(Document document) {
        repository.add(document);
    }

    public List<Long> delete(List<Long> list) {
        repository.delete(list, Document.class);
        return list;
    }

    public void update(Document item) {
        repository.update(item);
    }
}
