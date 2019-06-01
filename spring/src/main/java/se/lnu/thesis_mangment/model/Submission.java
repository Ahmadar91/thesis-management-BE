package se.lnu.thesis_mangment.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "submission")
public class Submission
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int step;
    @CreationTimestamp
    private Timestamp deadline;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getStep()
    {
        return step;
    }

    public void setStep(int step)
    {
        this.step = step;
    }

    public Timestamp getDeadline()
    {
        return deadline;
    }

    public void setDeadline(Timestamp deadline)
    {
        this.deadline = deadline;
    }
}
