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
    //  @Column(name = "title")
    private String title;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
//    private User author;

    private long authorId;
    private long opponentId;
    private long supervisorId;
    private long readerFeedbackId;
    private long opponentFeedbackId;

    private long deleted;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "opponent_id")
//    private User opponent;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "supervisor_id")
//    private User supervisor;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "reader_feedback_id")
//    private Feedback readerFeedback;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "opponent_feedback_id")
//    private Feedback opponentFeedback;

    //   @Column(name = "grade_num")
    private int gradeNum;
    //  @Column(name = "passed")
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

    public long getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(long authorId)
    {
        this.authorId = authorId;
    }

    public long getOpponentId()
    {
        return opponentId;
    }

    public void setOpponentId(long opponentId)
    {
        this.opponentId = opponentId;
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

    public long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(long deleted)
    {
        this.deleted = deleted;
    }
}
