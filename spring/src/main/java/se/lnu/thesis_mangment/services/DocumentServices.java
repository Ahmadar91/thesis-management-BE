package se.lnu.thesis_mangment.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.repositories.DocumentRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentServices
{
    @Autowired
    private DocumentRepository repository;

    public List<Document> get(DocumentInput input)
    {
        return repository.get(input);
    }

    public Document getDocument(DocumentInput input)
    {
        return repository.get(input).get(0);
    }

    public Long count()
    {
        return repository.count(Document.class);
    }

    @Transactional
    public void add(Document document)
    {
        repository.add(document);
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

    public Resource downloadFile(String fileName) throws MalformedURLException, NotFoundException
    {

        Path path = Paths.get("./src/main/resources/uploads/" + fileName);
        path.resolve(fileName).normalize();
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists())
        {
            return resource;
        } else
        {
            throw new NotFoundException("The file doesn't exist! File name should be in the following form: 'document" + "Id'.pdf");
        }
    }

//    public List<Long> delete(Long id)
//    {
//        repository.delete(list, Document.class);
//        return list;
//    }


//    public Document create(Document item)
//    {
//        return repository.save(item);
//    }

//    @Transactional
//    public void update(Document document, long id)
//    {
//        Document oldDocument = (Document) baseItemRepository.get(id, Document.class);
//        repository.update(document);
//
//    }
}
