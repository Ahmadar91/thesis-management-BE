package se.lnu.thesis_mangment.model;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
