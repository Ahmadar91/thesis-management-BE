package se.lnu.thesis_mangment.model;

import javax.persistence.*;

/**
 * The type Document.
 */
@Entity
@Table(name = "document")
public class Document
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String title;
    private Long type;
    private Long supervisorFeedbackId;
    private Long authorId;
    private Long opponentId;
    private Long supervisorId;
    private Long readerFeedbackId;
    private Long opponentFeedbackId;
    private Long deleted;
    private int gradeNum;
    private int gradePass;

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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Long getType()
    {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Long type)
    {
        this.type = type;
    }

    /**
     * Gets supervisor feedback id.
     *
     * @return the supervisor feedback id
     */
    public Long getSupervisorFeedbackId()
    {
        return supervisorFeedbackId;
    }

    /**
     * Sets supervisor feedback id.
     *
     * @param supervisorFeedbackId the supervisor feedback id
     */
    public void setSupervisorFeedbackId(Long supervisorFeedbackId)
    {
        this.supervisorFeedbackId = supervisorFeedbackId;
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
     * Gets opponent id.
     *
     * @return the opponent id
     */
    public Long getOpponentId()
    {
        return opponentId;
    }

    /**
     * Sets opponent id.
     *
     * @param opponentId the opponent id
     */
    public void setOpponentId(Long opponentId)
    {
        this.opponentId = opponentId;
    }

    /**
     * Gets supervisor id.
     *
     * @return the supervisor id
     */
    public Long getSupervisorId()
    {
        return supervisorId;
    }

    /**
     * Sets supervisor id.
     *
     * @param supervisorId the supervisor id
     */
    public void setSupervisorId(Long supervisorId)
    {
        this.supervisorId = supervisorId;
    }

    /**
     * Gets reader feedback id.
     *
     * @return the reader feedback id
     */
    public Long getReaderFeedbackId()
    {
        return readerFeedbackId;
    }

    /**
     * Sets reader feedback id.
     *
     * @param readerFeedbackId the reader feedback id
     */
    public void setReaderFeedbackId(Long readerFeedbackId)
    {
        this.readerFeedbackId = readerFeedbackId;
    }

    /**
     * Gets opponent feedback id.
     *
     * @return the opponent feedback id
     */
    public Long getOpponentFeedbackId()
    {
        return opponentFeedbackId;
    }

    /**
     * Sets opponent feedback id.
     *
     * @param opponentFeedbackId the opponent feedback id
     */
    public void setOpponentFeedbackId(Long opponentFeedbackId)
    {
        this.opponentFeedbackId = opponentFeedbackId;
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

    /**
     * Gets grade num.
     *
     * @return the grade num
     */
    public int getGradeNum()
    {
        return gradeNum;
    }

    /**
     * Sets grade num.
     *
     * @param gradeNum the grade num
     */
    public void setGradeNum(int gradeNum)
    {
        this.gradeNum = gradeNum;
    }

    /**
     * Gets grade pass.
     *
     * @return the grade pass
     */
    public int getGradePass()
    {
        return gradePass;
    }

    /**
     * Sets grade pass.
     *
     * @param gradePass the grade pass
     */
    public void setGradePass(int gradePass)
    {
        this.gradePass = gradePass;
    }


}

