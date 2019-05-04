package se.lnu.thesis_mangment.model;

import javax.persistence.*;

@Entity
@Table(name = "biddings")
public class Bidding
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "reader_id")
    private long readerId;
    @Column(name = "report_id")
    private long reportId;
    @Column(name = "bidding_number")
    private long biddingNumber;
    @Column(name = "assigned")
    private int assigned;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getReaderId()
    {
        return readerId;
    }

    public void setReaderId(long readerId)
    {
        this.readerId = readerId;
    }

    public long getReportId()
    {
        return reportId;
    }

    public void setReportId(long reportId)
    {
        this.reportId = reportId;
    }

    public long getBiddingNumber()
    {
        return biddingNumber;
    }

    public void setBiddingNumber(long biddingNumber)
    {
        this.biddingNumber = biddingNumber;
    }

    public int getAssigned()
    {
        return assigned;
    }

    public void setAssigned(int assigned)
    {
        this.assigned = assigned;
    }


}
