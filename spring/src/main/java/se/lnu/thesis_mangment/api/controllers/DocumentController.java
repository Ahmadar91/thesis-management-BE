package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.services.DocumentServices;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;


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
    //   @ResponseStatus(HttpStatus.OK)
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException
    {
        documentServices.storeFile(file);
    }

    @RequestMapping("/{id}")
    @Transactional
    public HashMap<String, Object> update(@Valid DocumentInput input)
    {
        Document newDocument = getDocumentFromInput(input);
        documentServices.update(newDocument, input.getId());
        return response(new ResponseArgument<>("document", newDocument));
    }

    @RequestMapping("/remove")
    @Transactional
    public void delete(@Valid DocumentInput input)
    {
        Document newDocument = getDocumentFromInput(input);
        //  documentServices.update(newDocument);
        // return response(new ResponseArgument<>("Document is", newDocument));
    }

    //@RequestMapping("/upload")

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

//    @RequestMapping("/signUp/{id}")
//    public void signUp(@RequestBody String firstName, @RequestBody String lastName, @RequestBody String email, @RequestBody String password)
//    {
//
//    }
//
//    @RequestMapping("/signIn")
//    public void signIn()
//    {
//
//    }
//
//    @RequestMapping("/signOut")
//    public void signOut()
//    {
//
//    }

}
