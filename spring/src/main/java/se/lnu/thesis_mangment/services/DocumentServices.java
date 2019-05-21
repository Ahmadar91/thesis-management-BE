package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se.lnu.thesis_mangment.model.*;
import se.lnu.thesis_mangment.repositories.DocumentRepository;
import se.lnu.thesis_mangment.repositories.base.BaseItemRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentServices
{
    @Autowired
    private DocumentRepository repository;
    @Autowired
    private BaseItemRepository baseItemRepository;
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

    public void storeFile(MultipartFile file) throws IOException
    {
        byte[] bytes = file.getBytes();
        Path path = Paths.get("./src/main/resources/uploads/" + file.getOriginalFilename());
        Files.write(path, bytes);
    }

//    public List<Long> delete(Long id)
//    {
//        repository.delete(list, Document.class);
//        return list;
//    }

    @Transactional
    public void add(Document document)
    {
        repository.add(document);
    }

    @Transactional
    public void update(Document document, long id)
    {
        Document oldDocument = (Document) baseItemRepository.get(id, Document.class);
        repository.update(document);

    }
}
