package se.lnu.thesis_mangment.model;


public class BiddingsDTO
{
    private long id;
    private long readerId;
    private long reportId;
    private long deleted;
    private int assigned;
    private int biddingNumber;

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

    public long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(long deleted)
    {
        this.deleted = deleted;
    }

    public int getAssigned()
    {
        return assigned;
    }

    public void setAssigned(int assigned)
    {
        this.assigned = assigned;
    }

    public int getBiddingNumber()
    {
        return biddingNumber;
    }

    public void setBiddingNumber(int biddingNumber)
    {
        this.biddingNumber = biddingNumber;
    }
}
