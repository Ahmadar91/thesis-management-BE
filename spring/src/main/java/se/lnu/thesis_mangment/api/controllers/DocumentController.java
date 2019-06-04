package se.lnu.thesis_mangment.api.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentDTO;
import se.lnu.thesis_mangment.services.DocumentServices;
import se.lnu.thesis_mangment.services.FileService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;


/**
 * The type Document controller.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/document")
public class DocumentController extends Controller {
    private static final String DOCUMENT = "document";
    @Autowired
    private DocumentServices documentServices;

    @Autowired
    private FileService fileService;


    /**
     * Get map.
     *
     * @param input the input
     * @return the map
     */
    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid DocumentDTO input)
    {
        return response(new ResponseArgument<>(DOCUMENT, documentServices.get(input)));
    }

    /**
     * Add map.
     *
     * @param input the input
     * @return the map
     * @throws IOException the io exception
     */
    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid DocumentDTO input) throws IOException
    {
        Document document = getDocumentFromInput(input);
        documentServices.add(document);

        // Save the file
        fileService.save(input.getFile(), document.getId().toString() + ".pdf");

        return response(new ResponseArgument<>(DOCUMENT, document));
    }


    /**
     * Download resource.
     *
     * @param input the input
     * @return the resource
     * @throws IOException       the io exception
     * @throws NotFoundException the not found exception
     */
    @GetMapping(value = "/download", produces = APPLICATION_PDF_VALUE)
    public Resource download(@Valid DocumentDTO input) throws IOException, NotFoundException
    {
        return fileService.get(input.getId() + ".pdf");
    }


    /**
     * Update document map.
     *
     * @param input the input
     * @return the map
     */
    @PostMapping(value = "/update/{id}")
    public Map<String, Object> updateDocument(@Valid DocumentDTO input)
    {
        DocumentDTO dInput = new DocumentDTO();
        dInput.setId(input.getId());
        Document document = getById(dInput);


        updateDocument(document, input);
        return response(new ResponseArgument<>(DOCUMENT, document));

    }

    /**
     * Gets by id.
     *
     * @param input the input
     * @return the by id
     */
    public Document getById(@Valid DocumentDTO input)
    {
        List<Document> documents = documentServices.get(input);
        if (documents.isEmpty()) {
            throw new ResourceNotFoundException("document not found");
        }
        return documents.get(0);
    }

    /**
     * Delete map.
     *
     * @param input the input
     * @return the map
     */
    @RequestMapping("/remove/{id}")
    @Transactional
    public Map<String, Object> delete(@Valid DocumentDTO input)
    {
        Document newDocument = getDocumentFromInput(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        documentServices.delete(list);
        return response(new ResponseArgument<>(DOCUMENT, newDocument));
    }

    private Document getDocumentFromInput(DocumentDTO input)
    {
        Document document = new Document();
        document.setTitle(input.getTitle());
        document.setAuthorId(input.getAuthorId());
        document.setGradeNum(input.getGradeNum());
        document.setOpponentId(input.getOpponentId());
        document.setType(input.getType());
        document.setOpponentFeedbackId(input.getOpponentFeedbackId());
        return document;
    }

    private void updateDocument(Document document, DocumentDTO input)
    {
        if (input.getAuthorId() != 0) {
            document.setAuthorId(input.getAuthorId());
        }
        if (input.getGradeNum() >= 0) {
            document.setGradeNum(input.getGradeNum());
        }
        if (input.getGradePass() >= 0) {
            document.setGradePass(input.getGradePass());
        }
        if (input.getTitle() != null)
        {
            document.setTitle(input.getTitle());
        }
        documentServices.update(document);
    }

}
