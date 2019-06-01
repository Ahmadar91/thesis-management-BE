package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Feedbacks;
import se.lnu.thesis_mangment.model.FeedbacksDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FeedbacksRepository extends BaseItemsRepository<Feedbacks>
{
    public List<Feedbacks> get(FeedbacksDTO input)
    {
        var searchBuilder = new BiddingsSearchBuilder(input);
        var stmt = "FROM Feedbacks AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, Feedbacks.class, searchBuilder.getParameterList());
    }

    @Transactional
    public void add(Feedbacks biddings)
    {
        save(biddings);
    }


    private class BiddingsSearchBuilder extends SearchBuilder
    {
        BiddingsSearchBuilder(FeedbacksDTO input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getDocumentId() > 0))
                {
                    super.add("and t.documentId = :documentId ", "documentId", input.getDocumentId());
                }
                if ((input.getStudentId() > 0))
                {
                    super.add("and t.studentId = :studentId ", "studentId", input.getStudentId());
                }
            }
        }
    }
}
