package se.lnu.thesis_mangment.model;


public class FeedbacksDTO
{

    private Long id;
    private Long studentId;
    private Long documentId;
    private Long deleted;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(Long documentId)
    {
        this.documentId = documentId;
    }

    public Long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Long deleted)
    {
        this.deleted = deleted;
    }
}