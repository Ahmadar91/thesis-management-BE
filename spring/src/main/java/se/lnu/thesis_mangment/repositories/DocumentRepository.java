package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Document;
import se.lnu.thesis_mangment.model.DocumentDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DocumentRepository extends BaseItemsRepository<Document>
{
    public List<Document> get(DocumentDTO input)
    {
        var searchBuilder = new DocumentSearchBuilder(input);
        var stmt = "FROM Document AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, Document.class, searchBuilder.getParameterList());
    }

    @Transactional
    public void add(Document document)
    {
        save(document);
    }


    private class DocumentSearchBuilder extends SearchBuilder
    {
        DocumentSearchBuilder(DocumentDTO input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getType() > 0))
                {
                    super.add("and t.type = :type ", "type", input.getType());
                }
                if ((input.getTitle() != null) && (!input.getTitle().isEmpty()))
                {
                    super.add("and t.title = :title ", "title", input.getTitle());
                }

                if ((input.getAuthorId() > 0))
                {
                    super.add("and t.authorId = :authorId ", "authorId", input.getAuthorId());
                }

                if ((input.getOpponentId() > 0))
                {
                    super.add("and t.opponentId = :opponentId ", "opponentId", input.getOpponentId());
                }
                if ((input.getSupervisorId() > 0))
                {
                    super.add("and t.supervisorId = :supervisorId ", "supervisorId", input.getSupervisorId());
                }
                if ((input.getReaderFeedbackId() > 0))
                {
                    super.add("and t.readerFeedbackId = :readerFeedbackId ", "readerFeedbackId", input.getReaderFeedbackId());
                }
                if ((input.getOpponentFeedbackId() > 0))
                {
                    super.add("and t.opponentFeedbackId = :opponentFeedbackId ", "opponentFeedbackId", input.getOpponentFeedbackId());
                }

                if ((input.getGradeNum() > 0))
                {
                    super.add("and t.gradeNum = :gradeNum ", "gradeNum", input.getGradeNum());
                }

                if ((input.getGradePass() > 0))
                {
                    super.add("and t.opponentFeedback = :opponentFeedbackId ", "opponentFeedbackId", input.getOpponentFeedbackId());
                }
            }
        }
    }
}
