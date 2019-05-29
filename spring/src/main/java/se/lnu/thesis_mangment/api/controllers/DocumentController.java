package se.lnu.thesis_mangment.api.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.services.DocumentServices;
import se.lnu.thesis_mangment.services.FileService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/document")
public class DocumentController extends Controller {
    private static final String DOCUMENT = "document";
    @Autowired
    private DocumentServices documentServices;

    @Autowired
    private FileService fileService;


    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid DocumentInput input) {
        return response(new ResponseArgument<>(DOCUMENT, documentServices.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid DocumentInput input) throws IOException {
        Document document = getDocumentFromInput(input);
        documentServices.add(document);

        // Save the file
        fileService.save(input.getFile(), document.getId().toString() + ".pdf");

        return response(new ResponseArgument<>(DOCUMENT, document));
    }


    @GetMapping(value = "/download", produces = APPLICATION_PDF_VALUE)
    public Resource download(@Valid DocumentInput input) throws IOException, NotFoundException {
        return fileService.get(input.getId() + ".pdf");
    }


    @PostMapping(value = "/update/{id}")
    public void updateDocument(@Valid DocumentInput input) {
        DocumentInput dInput = new DocumentInput();
        dInput.setId(input.getId());
        Document document = getById(dInput);


        updateDocument(document, input);
    }

    public Document getById(@Valid DocumentInput input) {
        List<Document> documents = documentServices.get(input);
        if (documents.isEmpty()) {
            throw new ResourceNotFoundException("document not found");
        }
        return documents.get(0);
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public Map<String, Object> delete(@Valid DocumentInput input) {
        Document newDocument = getDocumentFromInput(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        documentServices.delete(list);
        return response(new ResponseArgument<>(DOCUMENT, newDocument));
    }

    private Document getDocumentFromInput(DocumentInput input) {
        Document document = new Document();
        document.setTitle(input.getTitle());
        document.setAuthorId(input.getAuthorId());
        document.setGradeNum(input.getGradeNum());
        document.setOpponentId(input.getOpponentId());
        document.setType(input.getType());
        document.setOpponentFeedbackId(input.getOpponentFeedbackId());
        return document;
    }

    private Document getDocumentFromInput(DocumentInput input, Document document) {
        document.setId(input.getId());
        document.setTitle(input.getTitle());
        document.setType(input.getType());
        document.setSupervisorFeedbackId(input.getSupervisorFeedbackId());
        document.setAuthorId(input.getAuthorId());
        document.setOpponentFeedbackId(input.getOpponentFeedbackId());
        document.setReaderFeedbackId(input.getReaderFeedbackId());
        document.setDeleted(input.getDeleted());
        document.setGradeNum(input.getGradeNum());
        document.setOpponentId(input.getOpponentId());
        document.setSupervisorId(input.getSupervisorId());
        document.setGradePass(input.getGradePass());
        return document;

    }

    private void updateDocument(Document document, DocumentInput input) {
        if (input.getAuthorId() != 0) {
            document.setAuthorId(input.getAuthorId());
        }
        if (input.getGradeNum() >= 0) {
            document.setGradeNum(input.getGradeNum());
        }
        if (input.getGradePass() >= 0) {
            document.setGradePass(input.getGradePass());
        }
        documentServices.update(document);
    }

}
