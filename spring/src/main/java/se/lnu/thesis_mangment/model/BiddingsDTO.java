package se.lnu.thesis_mangment.model;


import org.springframework.web.multipart.MultipartFile;

public class BiddingsDTO
{
    private long id;
    private String title;
    private long type;
    private long supervisorFeedbackId;
    private long authorId;
    private long opponentId;
    private long supervisorId;
    private long readerFeedbackId;
    private long opponentFeedbackId;
    private long deleted;
    private int gradeNum;
    private int gradePass;
    private MultipartFile file;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(long authorId)
    {
        this.authorId = authorId;
    }

    public long getType()
    {
        return type;
    }

    public void setType(long type)
    {
        this.type = type;
    }

    public long getSupervisorFeedbackId()
    {
        return supervisorFeedbackId;
    }

    public void setSupervisorFeedbackId(long supervisorFeedbackId)
    {
        this.supervisorFeedbackId = supervisorFeedbackId;
    }

    public long getSupervisorId()
    {
        return supervisorId;
    }


    public void setSupervisorId(long supervisorId)
    {
        this.supervisorId = supervisorId;
    }


    public long getReaderFeedbackId()
    {
        return readerFeedbackId;
    }


    public void setReaderFeedbackId(long readerFeedbackId)
    {
        this.readerFeedbackId = readerFeedbackId;
    }

    public long getOpponentFeedbackId()
    {
        return opponentFeedbackId;
    }


    public void setOpponentFeedbackId(long opponentFeedbackId)
    {
        this.opponentFeedbackId = opponentFeedbackId;
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


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public long getOpponentId()
    {
        return opponentId;
    }


    public void setOpponentId(long opponentId)
    {
        this.opponentId = opponentId;
    }

    public long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(long deleted)
    {
        this.deleted = deleted;
    }

    public MultipartFile getFile()
    {
        return file;
    }

    public void setFile(MultipartFile file)
    {
        this.file = file;
    }
}
