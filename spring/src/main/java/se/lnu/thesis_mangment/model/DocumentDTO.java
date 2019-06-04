package se.lnu.thesis_mangment.model;


import org.springframework.web.multipart.MultipartFile;

/**
 * The type Document dto.
 */
public class DocumentDTO
{
    private long id;
    private String title;
    private long type;
    private long supervisorFeedbackId;
    private long authorId;
    private long opponentId;
    private long supervisorId;
    private long readerFeedbackId;
    private long opponentFeedbackId;
    private long deleted = 0;
    private int gradeNum;
    private int gradePass;
    private MultipartFile file;

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

    /**
     * Gets author id.
     *
     * @return the author id
     */
    public long getAuthorId() {
        return authorId;
    }

    /**
     * Sets author id.
     *
     * @param authorId the author id
     */
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public long getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(long type) {
        this.type = type;
    }

    /**
     * Gets supervisor feedback id.
     *
     * @return the supervisor feedback id
     */
    public long getSupervisorFeedbackId() {
        return supervisorFeedbackId;
    }

    /**
     * Sets supervisor feedback id.
     *
     * @param supervisorFeedbackId the supervisor feedback id
     */
    public void setSupervisorFeedbackId(long supervisorFeedbackId) {
        this.supervisorFeedbackId = supervisorFeedbackId;
    }

    /**
     * Gets supervisor id.
     *
     * @return the supervisor id
     */
    public long getSupervisorId() {
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

    public long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(long deleted)
    {
        this.deleted = deleted;
    }

    /**
     * Gets reader feedback id.
     *
     * @return the reader feedback id
     */
    public long getReaderFeedbackId() {
        return readerFeedbackId;
    }


    /**
     * Sets reader feedback id.
     *
     * @param readerFeedbackId the reader feedback id
     */
    public void setReaderFeedbackId(long readerFeedbackId) {
        this.readerFeedbackId = readerFeedbackId;
    }

    /**
     * Gets opponent feedback id.
     *
     * @return the opponent feedback id
     */
    public long getOpponentFeedbackId() {
        return opponentFeedbackId;
    }


    /**
     * Sets opponent feedback id.
     *
     * @param opponentFeedbackId the opponent feedback id
     */
    public void setOpponentFeedbackId(long opponentFeedbackId) {
        this.opponentFeedbackId = opponentFeedbackId;
    }


    /**
     * Gets grade num.
     *
     * @return the grade num
     */
    public int getGradeNum() {
        return gradeNum;
    }


    /**
     * Sets grade num.
     *
     * @param gradeNum the grade num
     */
    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }


    /**
     * Gets grade pass.
     *
     * @return the grade pass
     */
    public int getGradePass() {
        return gradePass;
    }


    /**
     * Sets grade pass.
     *
     * @param gradePass the grade pass
     */
    public void setGradePass(int gradePass) {
        this.gradePass = gradePass;
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


    /**
     * Gets opponent id.
     *
     * @return the opponent id
     */
    public long getOpponentId() {
        return opponentId;
    }


    /**
     * Sets opponent id.
     *
     * @param opponentId the opponent id
     */
    public void setOpponentId(long opponentId) {
        this.opponentId = opponentId;
    }


    /**
     * Gets file.
     *
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * Sets file.
     *
     * @param file the file
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
