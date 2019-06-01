package se.lnu.thesis_mangment.model;

public class SupervisorsConfirmationDTO
{

    private long id;
    private long supervisorId;
    private long studentId;
    private int confirmed;
    private int projectPlanId;


    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public long getSupervisorId()
    {
        return supervisorId;
    }

    public void setSupervisorId(long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getProjectPlanId() {
        return projectPlanId;
    }

    public void setProjectPlanId(int projectPlanId) {
        this.projectPlanId = projectPlanId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
