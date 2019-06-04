package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.Parameter;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Users repository.
 */
@Repository
public class UsersRepository extends BaseItemsRepository<User>
{
    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<User> get(UsersDTO input)
    {
        var searchBuilder = new UsersSearchBuilder(input);
        var stmt = "FROM User AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, User.class, searchBuilder.getParameterList());
    }

    /**
     * Gets user.
     *
     * @param inputs the inputs
     * @return the user
     */
// can be used to authinticate a user
    public User getUser(UsersDTO inputs)
    {
        var searchBuilder = new UsersSearchBuilder(inputs);
        var stmt = "FROM User AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return select(stmt, User.class, searchBuilder.getParameterList());
    }

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    public User findByUsername(String username)
    {
        var stmt = "FROM User AS t " + "where " + "t.deleted = 0 and t.username = :username";
        return select(stmt, User.class, new Parameter<>("username", username));
    }

    /**
     * Add.
     *
     * @param user the user
     */
    @Transactional
    public void add(User user)
    {
        save(user);
    }


    private class UsersSearchBuilder extends SearchBuilder
    {
        /**
         * Instantiates a new Users search builder.
         *
         * @param input the input
         */
        UsersSearchBuilder(UsersDTO input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    super.add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getUsername() != null) && (!input.getUsername().isEmpty()))
                {
                    super.add("and t.username = :username ", "username", input.getUsername());
                }
                if ((input.getRoleId() > 0))
                {
                    super.add("and t.roleId = :roleId ", "roleId", input.getRoleId());
                }
                if ((input.getFirstName() != null) && (!input.getFirstName().isEmpty()))
                {
                    super.add("and t.firstName = :firstName ", "firstName", input.getFirstName());
                }
                if ((input.getEmail() != null) && (!input.getEmail().isEmpty()))
                {
                    super.add("and t.email = :email ", "email", input.getEmail());
                }
                if ((input.getSupervisorId() != null) && (input.getSupervisorId() >= 0))
                {
                    super.add("and t.supervisorId = :supervisorId ", "supervisorId", input.getSupervisorId());
                }
            }
        }
    }
}
