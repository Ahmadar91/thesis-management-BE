package se.lnu.thesis_mangment.api.controllers;

import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.model.Document;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tasks")
public class TaskController
{
    private List<Document> documentsList;

    public TaskController()
    {
        documentsList = new ArrayList<>();
    }

    // @RequestMapping(value = {"","/", "/home"}, method = RequestMethod.GET)
    @PostMapping(value = {"/submit"})
    public void submit(@RequestBody Document task)
    {
        documentsList.add(task);
    }

    @DeleteMapping(value = {"/delete"})
    public void delete(@RequestBody Document task)
    {
        documentsList.remove(task);
    }

    @PutMapping(value = {"/edit"})
    public void edit(Document oldTask, Document newTask)
    {
        documentsList.set(documentsList.indexOf(oldTask), newTask);
    }

    public List<Document> getDocumentsList()
    {
        return documentsList;
    }

    public void setDocumentsList(List<Document> documentsList)
    {
        this.documentsList = documentsList;
    }
}
