package se.lnu.thesis_mangment.model;

import javax.validation.constraints.NotNull;

public class DocumentInput
{

    @NotNull
    private int authorId = 0;

    @NotNull
    private int opponentId = 0;

    @NotNull
    private String title;

    @NotNull
    private int supervisorId;

    @NotNull
    private int readerFeedbackId;

    @NotNull
    private int opponentFeedbackId;

    @NotNull
    private int gradeNum = 0;

    @NotNull
    private int gradePass = 0;

    public int getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(int authorId)
    {
        this.authorId = authorId;
    }

    public int getOpponentId()
    {
        return opponentId;
    }

    public void setOpponentId(int opponentId)
    {
        this.opponentId = opponentId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getSupervisorId()
    {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId)
    {
        this.supervisorId = supervisorId;
    }

    public int getReaderFeedbackId()
    {
        return readerFeedbackId;
    }

    public void setReaderFeedbackId(int readerFeedbackId)
    {
        this.readerFeedbackId = readerFeedbackId;
    }

    public int getOpponentFeedbackId()
    {
        return opponentFeedbackId;
    }

    public void setOpponentFeedbackId(int opponentFeedbackId)
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
}
