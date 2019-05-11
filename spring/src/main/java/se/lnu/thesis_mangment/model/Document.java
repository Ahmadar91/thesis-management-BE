package se.lnu.thesis_mangment.model;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document
{
    // id1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //  @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opponent_id")
    private User opponent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id")
    private User supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reader_feedback_id")
    private Feedback readerFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opponent_feedback_id")
    private Feedback opponentFeedback;

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

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    public User getOpponent()
    {
        return opponent;
    }

    public void setOpponent(User opponent)
    {
        this.opponent = opponent;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public User getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(User supervisor)
    {
        this.supervisor = supervisor;
    }

    public Feedback getReaderFeedback()
    {
        return readerFeedback;
    }

    public void setReaderFeedback(Feedback readerFeedback)
    {
        this.readerFeedback = readerFeedback;
    }

    public Feedback getOpponentFeedback()
    {
        return opponentFeedback;
    }

    public void setOpponentFeedback(Feedback opponentFeedback)
    {
        this.opponentFeedback = opponentFeedback;
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
