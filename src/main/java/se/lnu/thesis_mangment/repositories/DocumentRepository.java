package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentInput;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import java.util.List;

@Repository
public class DocumentRepository extends BaseItemsRepository<Document>
{
    public List<Document> get(DocumentInput input)
    {
        var searchBuilder = new DocumentSearchBuilder(input);
        var stmt = "FROM Document AS t " + "left join fetch t.role " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, Document.class, searchBuilder.getParameterList());
    }

    private class DocumentSearchBuilder extends SearchBuilder
    {
        DocumentSearchBuilder(DocumentInput input)
        {
            if (input != null)
            {

                if ((input.getTitle() != null) && (!input.getTitle().isEmpty()))
                {
                    add("and t.title = :title ", "title", "%" + input.getTitle() + "%");
                }

                if ((input.getAuthorId() > 0))
                {
                    add("and t.author = :authorId ", "authorId", input.getAuthorId());
                }

                if ((input.getOpponentId() > 0))
                {
                    add("and t.opponent = :opponentId ", "opponentId", input.getOpponentId());
                }
                if ((input.getSupervisorId() > 0))
                {
                    add("and t.supervisor = :supervisorId ", "supervisorId", input.getSupervisorId());
                }
                if ((input.getReaderFeedbackId() > 0))
                {
                    add("and t.readerFeedback = :readerFeedbackId ", "readerFeedbackId", input.getReaderFeedbackId());
                }
                if ((input.getOpponentFeedbackId() > 0))
                {
                    add("and t.opponentFeedback = :opponentFeedbackId ", "opponentFeedbackId", input.getOpponentFeedbackId());
                }

                if ((input.getGradeNum() > 0))
                {
                    add("and t.gradeNum = :gradeNum ", "gradeNum", input.getGradeNum());
                }

                if ((input.getGradePass() > 0))
                {
                    add("and t.opponentFeedback = :opponentFeedbackId ", "opponentFeedbackId", input.getOpponentFeedbackId());
                }
            }
        }
    }
}
