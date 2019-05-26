package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UsersRepository extends BaseItemsRepository<User>
{
    public List<User> get(UsersInput input)
    {
        var searchBuilder = new UsersSearchBuilder(input);
        var stmt = "FROM User AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, User.class, searchBuilder.getParameterList());
    }

    // can be used to authinticate a user
    public User getUser(UsersInput inputs)
    {
        var searchBuilder = new UsersSearchBuilder(inputs);
        var stmt = "FROM User AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return select(stmt, User.class, searchBuilder.getParameterList());
    }

    @Transactional
    public void add(User user)
    {
        save(user);
    }


    private class UsersSearchBuilder extends SearchBuilder
    {
        UsersSearchBuilder(UsersInput input)
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
            }
        }
    }
}
