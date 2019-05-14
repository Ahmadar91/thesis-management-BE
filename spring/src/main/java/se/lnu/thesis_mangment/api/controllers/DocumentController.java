package se.lnu.thesis_mangment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.model.LoginInput;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.services.DocumentServices;
import se.lnu.thesis_mangment.services.UserServices;

import javax.print.Doc;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/document")
public class DocumentController extends Controller
{
    @Autowired
    private DocumentServices documentServices;

    @RequestMapping("/get")
    public HashMap<String, Object> get(@Valid DocumentInput input)
    {
        return response(new ResponseArgument<>("Document is", documentServices.get(input)));
    }

    @RequestMapping("/add")
    @Transactional
    public HashMap<String, Object> add(@Valid DocumentInput input)
    {
        Document document = getDocumentFromInput(input);
        documentServices.add(document);
        return response(new ResponseArgument<>("User is", document));
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
