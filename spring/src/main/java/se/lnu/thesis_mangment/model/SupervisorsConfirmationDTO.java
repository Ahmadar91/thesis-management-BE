package se.lnu.thesis_mangment.model;

/**
 * The type Supervisors confirmation dto.
 */
public class SupervisorsConfirmationDTO
{

    private long id;
    private long supervisorId;
    private long studentId;
    private int confirmed;
    private int projectPlanId;


    private User user;

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
    public void setSupervisorId(long supervisorId) {
        this.supervisorId = supervisorId;
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets confirmed.
     *
     * @return the confirmed
     */
    public int getConfirmed() {
        return confirmed;
    }

    /**
     * Sets confirmed.
     *
     * @param confirmed the confirmed
     */
    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Gets project plan id.
     *
     * @return the project plan id
     */
    public int getProjectPlanId() {
        return projectPlanId;
    }

    /**
     * Sets project plan id.
     *
     * @param projectPlanId the project plan id
     */
    public void setProjectPlanId(int projectPlanId) {
        this.projectPlanId = projectPlanId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }
}
