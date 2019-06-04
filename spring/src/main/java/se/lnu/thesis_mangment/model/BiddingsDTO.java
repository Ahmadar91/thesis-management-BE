package se.lnu.thesis_mangment.model;


/**
 * The type Biddings dto.
 */
public class BiddingsDTO
{
    private long id;
    private long readerId;
    private long reportId;
    private long deleted;
    private int assigned;
    private int biddingNumber;

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * Gets reader id.
     *
     * @return the reader id
     */
    public long getReaderId()
    {
        return readerId;
    }

    /**
     * Sets reader id.
     *
     * @param readerId the reader id
     */
    public void setReaderId(long readerId)
    {
        this.readerId = readerId;
    }

    /**
     * Gets report id.
     *
     * @return the report id
     */
    public long getReportId()
    {
        return reportId;
    }

    /**
     * Sets report id.
     *
     * @param reportId the report id
     */
    public void setReportId(long reportId)
    {
        this.reportId = reportId;
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
     * Gets assigned.
     *
     * @return the assigned
     */
    public int getAssigned()
    {
        return assigned;
    }

    /**
     * Sets assigned.
     *
     * @param assigned the assigned
     */
    public void setAssigned(int assigned)
    {
        this.assigned = assigned;
    }

    /**
     * Gets bidding number.
     *
     * @return the bidding number
     */
    public int getBiddingNumber()
    {
        return biddingNumber;
    }

    /**
     * Sets bidding number.
     *
     * @param biddingNumber the bidding number
     */
    public void setBiddingNumber(int biddingNumber)
    {
        this.biddingNumber = biddingNumber;
    }
}
