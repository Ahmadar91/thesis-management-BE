package se.lnu.thesis_mangment.model;

import javax.persistence.*;

/**
 * The type Supervisors confirmation.
 */
@Entity
@Table(name = "supervisorsConfirmation")
public class SupervisorsConfirmation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private long supervisorId;
    private int confirmed;
    private int projectPlanId;
    private long deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private User user;

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
     * Gets supervisor id.
     *
     * @return the supervisor id
     */
    public long getSupervisorId()
    {
        return supervisorId;
    }

    /**
     * Sets supervisor id.
     *
     * @param supervisorId the supervisor id
     */
    public void setSupervisorId(long supervisorId)
    {
        this.supervisorId = supervisorId;
    }

    /**
     * Gets confirmed.
     *
     * @return the confirmed
     */
    public int getConfirmed()
    {
        return confirmed;
    }

    /**
     * Sets confirmed.
     *
     * @param confirmed the confirmed
     */
    public void setConfirmed(int confirmed)
    {
        this.confirmed = confirmed;
    }

    /**
     * Gets project plan id.
     *
     * @return the project plan id
     */
    public int getProjectPlanId()
    {
        return projectPlanId;
    }

    /**
     * Sets project plan id.
     *
     * @param projectPlanId the project plan id
     */
    public void setProjectPlanId(int projectPlanId)
    {
        this.projectPlanId = projectPlanId;
    }

    /**
     * Gets deleted.
     *
     * @return the deleted
     */
    public long getDeleted()
    {
        return deleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(long deleted)
    {
        this.deleted = deleted;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user)
    {
        this.user = user;
    }
}
