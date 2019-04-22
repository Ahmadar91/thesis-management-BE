package se.lnu.thesis_mangment.api.controllers;

import org.springframework.web.bind.annotation.*;
import se.lnu.thesis_mangment.model.Task;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController
{
    private List<Task> documentsList;

    public TaskController()
    {
        documentsList = new ArrayList<>();
    }

    // @RequestMapping(value = {"","/", "/home"}, method = RequestMethod.GET)
    @RequestMapping(value = {"/submit"}, method = RequestMethod.POST)
    public void submit(@RequestBody Task task)
    {
        documentsList.add(task);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void delete(@RequestBody Task task)
    {
        documentsList.remove(task);
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
    public void edit(Task oldTask, Task newTask)
    {
        documentsList.set(documentsList.indexOf(oldTask), newTask);
    }

    public List<Task> getDocumentsList()
    {
        return documentsList;
    }

    public void setDocumentsList(List<Task> documentsList)
    {
        this.documentsList = documentsList;
    }
}
