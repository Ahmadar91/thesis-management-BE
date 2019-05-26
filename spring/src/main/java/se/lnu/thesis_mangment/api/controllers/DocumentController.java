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
import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/document")
public class DocumentController extends Controller
{
    @Autowired
    private DocumentServices documentServices;


    @RequestMapping(value = "/get")
    public HashMap<String, Object> get(@Valid DocumentInput input)
    {
        return response(new ResponseArgument<>("document", documentServices.get(input)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Transactional
    public HashMap<String, Object> add(@Valid DocumentInput input)
    {
        Document document = getDocumentFromInput(input);
        documentServices.add(document);
        return response(new ResponseArgument<>("document", document));
    }

    @PostMapping(value = "/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException
    {
        documentServices.storeFile(file);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public Resource download(@Valid DocumentInput input) throws IOException, NotFoundException
    {
        String fileName = input.getId() + ".pdf";
        return documentServices.downloadFile(fileName);
    }


    //    @RequestMapping("/update/{id}")
//    @Transactional
//    public void update(@Valid DocumentInput input)
//    {
//        delete(input);
//        add(input);
//    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @Modifying
    void setUserInfoById(@Valid DocumentInput input)
    {
        DocumentInput dInput = new DocumentInput();
        dInput.setId(input.getId());
        Document document = getById(dInput);

        documentServices.add(getDocumentFromInput(input, document));
        System.out.println("hello");
    }

    public Document getById(@Valid DocumentInput input)
    {
        return documentServices.getDocument(input);
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public HashMap<String, Object> delete(@Valid DocumentInput input)
    {
        Document newDocument = getDocumentFromInput(input);
        List<Long> list = new ArrayList<>();
        list.add(input.getId());
        documentServices.delete(list);
        return response(new ResponseArgument<>("document", newDocument));
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
        /*


    private long deleted;
    private int gradeNum;
    private int gradePass;
         */
    }

}
