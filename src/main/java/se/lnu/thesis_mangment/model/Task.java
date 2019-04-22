package se.lnu.thesis_mangment.model;

public class Task
{
    TaskType type;
    private String title;
    private String author;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public TaskType getType()
    {
        return type;
    }

    public void setType(TaskType type)
    {
        this.type = type;
    }
}
