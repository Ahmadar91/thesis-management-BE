package se.lnu.thesis_mangment.model;

public class SupervisorsConfirmationInput {

    private long supervisorId;
    private long studentId;
    private int confirmed;
    private int projectPlanId;

    public long getSupervisorId() {
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
}
