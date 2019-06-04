package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.SupervisorsConfirmation;
import se.lnu.thesis_mangment.model.SupervisorsConfirmationDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Supervisors confirmation repository.
 */
@Repository
public class SupervisorsConfirmationRepository extends BaseItemsRepository<SupervisorsConfirmation>
{
    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<SupervisorsConfirmation> get(SupervisorsConfirmationDTO input)
    {
        var searchBuilder = new SupervisorConfirmationBuilder(input);
        var stmt = "FROM SupervisorsConfirmation AS t " + "left join fetch t.user " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();

        return selectAll(stmt, SupervisorsConfirmation.class, searchBuilder.getParameterList());
    }

    /**
     * Add.
     *
     * @param supervisorsConfirmation the supervisors confirmation
     */
    @Transactional
    public void add(SupervisorsConfirmation supervisorsConfirmation)
    {
        save(supervisorsConfirmation);
    }


    private class SupervisorConfirmationBuilder extends SearchBuilder
    {
        /**
         * Instantiates a new Supervisor confirmation builder.
         *
         * @param input the input
         */
        SupervisorConfirmationBuilder(SupervisorsConfirmationDTO input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getSupervisorId() > 0))
                {
                    super.add("and t.supervisorId = :supervisorId ", "supervisorId", input.getSupervisorId());
                }

                if ((input.getStudentId() > 0))
                {
                    super.add("and t.studentId = :studentId ", "studentId", input.getStudentId());
                }
                // can be equals to zero, in order to know the students who got rejected
                if ((input.getConfirmed() > 0))
                {
                    super.add("and t.supervisorId = :supervisorId ", "supervisorId", input.getSupervisorId());
                }
                if ((input.getProjectPlanId() > 0))
                {
                    super.add("and t.projectPlanId = :projectPlanId ", "projectPlanId", input.getProjectPlanId());
                }
            }
        }
    }
}
