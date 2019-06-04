package se.lnu.thesis_mangment.model;


import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * The type Submission dto.
 */
public class SubmissionDTO {

    private Long id;
    private int step;
    private String title;
    @CreationTimestamp
    private Timestamp deadline;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets step.
     *
     * @return the step
     */
    public int getStep() {
        return step;
    }

    /**
     * Sets step.
     *
     * @param step the step
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * Gets deadline.
     *
     * @return the deadline
     */
    public Timestamp getDeadline() {
        return deadline;
    }

    /**
     * Sets deadline.
     *
     * @param deadline the deadline
     */
    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
