package se.lnu.thesis_mangment.model;

import javax.persistence.*;

/**
 * The type Biddings.
 */
@Entity
@Table(name = "biddings")
public class Biddings
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reader_id")
    private Long readerId;
    @Column(name = "report_id")
    private Long reportId;
    @Column(name = "bidding_number")
    private Long biddingNumber;
    @Column(name = "assigned")
    private int assigned;

    private Long deleted;

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
     * Gets bidding number.
     *
     * @return the bidding number
     */
    public long getBiddingNumber()
    {
        return biddingNumber;
    }

    /**
     * Sets bidding number.
     *
     * @param biddingNumber the bidding number
     */
    public void setBiddingNumber(long biddingNumber)
    {
        this.biddingNumber = biddingNumber;
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
     * Gets deleted.
     *
     * @return the deleted
     */
    public Long getDeleted()
    {
        return deleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(Long deleted)
    {
        this.deleted = deleted;
    }
}
