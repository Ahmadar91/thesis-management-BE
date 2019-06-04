package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Feedbacks;
import se.lnu.thesis_mangment.model.FeedbacksDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Feedbacks repository.
 */
@Repository
public class FeedbacksRepository extends BaseItemsRepository<Feedbacks>
{
    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Feedbacks> get(FeedbacksDTO input)
    {
        var searchBuilder = new BiddingsSearchBuilder(input);
        var stmt = "FROM Feedbacks AS t " + "left join fetch t.document " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, Feedbacks.class, searchBuilder.getParameterList());
    }

    /**
     * Add.
     *
     * @param biddings the biddings
     */
    @Transactional
    public void add(Feedbacks biddings)
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
        BiddingsSearchBuilder(FeedbacksDTO input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getAuthorId() != null && input.getAuthorId() > 0))
                {
                    super.add("and t.authorId = :authorId ", "authorId", input.getAuthorId());
                }
            }
        }
    }
}
