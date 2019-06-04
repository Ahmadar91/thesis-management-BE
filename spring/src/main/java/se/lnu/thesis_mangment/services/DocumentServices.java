package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentDTO;
import se.lnu.thesis_mangment.repositories.DocumentRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Document services.
 */
@Service
public class DocumentServices {
    @Autowired
    private DocumentRepository repository;

    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Document> get(DocumentDTO input)
    {
        return repository.get(input);
    }

    /**
     * Count long.
     *
     * @return the long
     */
    public Long count() {
        return repository.count(Document.class);
    }

    /**
     * Add.
     *
     * @param document the document
     */
    @Transactional
    public void add(Document document) {
        repository.add(document);
    }

    /**
     * Delete list.
     *
     * @param list the list
     * @return the list
     */
    public List<Long> delete(List<Long> list) {
        repository.delete(list, Document.class);
        return list;
    }

    /**
     * Update.
     *
     * @param item the item
     */
    public void update(Document item) {
        repository.update(item);
    }
}
