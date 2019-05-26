package se.lnu.thesis_mangment.model;

import javax.persistence.*;

@Entity
@Table(name = "supervisorsConfirmation")
public class SupervisorsConfirmation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private long supervisorId;
    private long studentId;
    private int confirmed;
    private int projectPlanId;
    private long deleted;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public long getSupervisorId()
    {
        return supervisorId;
    }

    public void setSupervisorId(long supervisorId)
    {
        this.supervisorId = supervisorId;
    }

    public long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(long studentId)
    {
        this.studentId = studentId;
    }

    public int getConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(int confirmed)
    {
        this.confirmed = confirmed;
    }

    public int getProjectPlanId()
    {
        return projectPlanId;
    }

    public void setProjectPlanId(int projectPlanId)
    {
        this.projectPlanId = projectPlanId;
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
