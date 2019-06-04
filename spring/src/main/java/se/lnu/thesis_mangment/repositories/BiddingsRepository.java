package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Biddings;
import se.lnu.thesis_mangment.model.BiddingsDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Biddings repository.
 */
@Repository
public class BiddingsRepository extends BaseItemsRepository<Biddings>
{
    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Biddings> get(BiddingsDTO input)
    {
        var searchBuilder = new BiddingsSearchBuilder(input);
        var stmt = "FROM Biddings AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, Biddings.class, searchBuilder.getParameterList());
    }

    /**
     * Add.
     *
     * @param biddings the biddings
     */
    @Transactional
    public void add(Biddings biddings)
    {
        save(biddings);
    }


    private class BiddingsSearchBuilder extends SearchBuilder
    {
        /**
         * Instantiates a new Biddings search builder.
         *
         * @param input the input
         */
        BiddingsSearchBuilder(BiddingsDTO input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getAssigned() > 0))
                {
                    super.add("and t.assigned = :assigned ", "assigned", input.getAssigned());
                }
                if ((input.getBiddingNumber() > 0))
                {
                    super.add("and t.biddingNumber = :biddingNumber ", "biddingNumber", input.getBiddingNumber());
                }

                if ((input.getReportId() > 0))
                {
                    super.add("and t.reportId = :reportId ", "reportId", input.getReportId());
                }

                if ((input.getReaderId() > 0))
                {
                    super.add("and t.readerId = :readerId ", "readerId", input.getReaderId());
                }
            }
        }
    }
}
