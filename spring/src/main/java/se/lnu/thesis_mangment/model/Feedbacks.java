package se.lnu.thesis_mangment.model;

import javax.persistence.*;

/**
 * The type Feedbacks.
 */
@Entity
@Table(name = "feedbacks")
public class Feedbacks
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    private Long authorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentId")
    private Document document;
    private Long deleted = 0L;

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

