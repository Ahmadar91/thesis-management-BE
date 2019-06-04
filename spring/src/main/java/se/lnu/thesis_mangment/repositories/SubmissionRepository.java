package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Submission;
import se.lnu.thesis_mangment.model.SubmissionDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Submission repository.
 */
@Repository
public class SubmissionRepository extends BaseItemsRepository<Submission>
{
    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Submission> get(SubmissionDTO input)
    {
        var searchBuilder = new SubmissionSearchBuilder(input);
        var stmt = "FROM Submission AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, Submission.class, searchBuilder.getParameterList());
    }

    /**
     * Add.
     *
     * @param submission the submission
     */
    @Transactional
    public void add(Submission submission)
    {
        save(submission);
    }


    private class SubmissionSearchBuilder extends SearchBuilder
    {
        /**
         * Instantiates a new Submission search builder.
         *
         * @param input the input
         */
        SubmissionSearchBuilder(SubmissionDTO input)
        {
            if (input != null)
            {
                if ((input.getId() != null && (input.getId() > 0)))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getStep() > 0))
                {
                    super.add("and t.step = :step ", "step", input.getStep());
                }
                if ((input.getDeadline() != null))
                {
                    super.add("and t.deadline = :deadline ", "deadline", input.getDeadline());
                }
            }
        }
    }
}
