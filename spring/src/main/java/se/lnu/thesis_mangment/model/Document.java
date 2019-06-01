package se.lnu.thesis_mangment.model;

import javax.persistence.*;

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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Long getType()
    {
        return type;
    }

    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getSupervisorFeedbackId()
    {
        return supervisorFeedbackId;
    }

    public void setSupervisorFeedbackId(Long supervisorFeedbackId)
    {
        this.supervisorFeedbackId = supervisorFeedbackId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public Long getOpponentId()
    {
        return opponentId;
    }

    public void setOpponentId(Long opponentId)
    {
        this.opponentId = opponentId;
    }

    public Long getSupervisorId()
    {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId)
    {
        this.supervisorId = supervisorId;
    }

    public Long getReaderFeedbackId()
    {
        return readerFeedbackId;
    }

    public void setReaderFeedbackId(Long readerFeedbackId)
    {
        this.readerFeedbackId = readerFeedbackId;
    }

    public Long getOpponentFeedbackId()
    {
        return opponentFeedbackId;
    }

    public void setOpponentFeedbackId(Long opponentFeedbackId)
    {
        this.opponentFeedbackId = opponentFeedbackId;
    }

    public Long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Long deleted)
    {
        this.deleted = deleted;
    }

    public int getGradeNum()
    {
        return gradeNum;
    }

    public void setGradeNum(int gradeNum)
    {
        this.gradeNum = gradeNum;
    }

    public int getGradePass()
    {
        return gradePass;
    }

    public void setGradePass(int gradePass)
    {
        this.gradePass = gradePass;
    }


}

