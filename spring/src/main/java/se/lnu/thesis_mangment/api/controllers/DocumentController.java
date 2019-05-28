package se.lnu.thesis_mangment.api.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.services.DocumentServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/document")
public class DocumentController extends Controller
{
    private static final String DOCUMENT = "document";
    @Autowired
    private DocumentServices documentServices;


    @GetMapping(value = "/get")
    public Map<String, Object> get(@Valid DocumentInput input)
    {
        return response(new ResponseArgument<>(DOCUMENT, documentServices.get(input)));
    }

    @PostMapping(value = "/add")
    @Transactional
    public Map<String, Object> add(@Valid DocumentInput input)
    {
        Document document = getDocumentFromInput(input);
        documentServices.add(document);
        return response(new ResponseArgument<>(DOCUMENT, document));
    }

    @PostMapping(value = "/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException
    {
        documentServices.storeFile(file);
    }

    @GetMapping(value = "/download")
    public Resource download(@Valid DocumentInput input) throws IOException, NotFoundException
    {
        String fileName = input.getId() + ".pdf";
        return documentServices.downloadFile(fileName);
    }


    @PostMapping(value = "/update/{id}")
    @Modifying
    void setUserInfoById(@Valid DocumentInput input)
    {
        DocumentInput dInput = new DocumentInput();
        dInput.setId(input.getId());
        Document document = getById(dInput);

        documentServices.add(getDocumentFromInput(input, document));
    }

    public Document getById(@Valid DocumentInput input)
    {
        return documentServices.getDocument(input);
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public Map<String, Object> delete(@Valid DocumentInput input)
    {
        Document newDocument = getDocumentFromInput(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        documentServices.delete(list);
        return response(new ResponseArgument<>(DOCUMENT, newDocument));
    }

    private Document getDocumentFromInput(DocumentInput input)
    {
        Document document = new Document();
        document.setTitle(input.getTitle());
        document.setAuthorId(input.getAuthorId());
        document.setGradeNum(input.getGradeNum());
        document.setOpponentId(input.getOpponentId());
        document.setOpponentFeedbackId(input.getOpponentFeedbackId());
        return document;
    }

    private Document getDocumentFromInput(DocumentInput input, Document document)
    {
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

}
