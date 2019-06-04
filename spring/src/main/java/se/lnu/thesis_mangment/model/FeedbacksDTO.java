package se.lnu.thesis_mangment.model;


import org.springframework.web.multipart.MultipartFile;

/**
 * The type Feedbacks dto.
 */
public class FeedbacksDTO
{

    private Long id;
    private Long authorId;
    private Document document;
    private Long deleted;
    private MultipartFile file;

    /**
     * Gets file.
     *
     * @return the file
     */
    public MultipartFile getFile()
    {
        return file;
    }

    /**
     * Sets file.
     *
     * @param file the file
     */
    public void setFile(MultipartFile file)
    {
        this.file = file;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets author id.
     *
     * @return the author id
     */
    public Long getAuthorId()
    {
        return authorId;
    }

    /**
     * Sets author id.
     *
     * @param authorId the author id
     */
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    /**
     * Gets document.
     *
     * @return the document
     */
    public Document getDocument()
    {
        return document;
    }

    /**
     * Sets document.
     *
     * @param document the document
     */
    public void setDocument(Document document)
    {
        this.document = document;
    }

    /**
     * Gets deleted.
     *
     * @return the deleted
     */
    public Long getDeleted()
    {
        return deleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(Long deleted)
    {
        this.deleted = deleted;
    }


}
