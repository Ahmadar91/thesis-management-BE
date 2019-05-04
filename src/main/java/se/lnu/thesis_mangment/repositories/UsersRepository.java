package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;
import se.lnu.thesis_mangment.repositories.query.SearchBuilder;

import java.util.List;

@Repository
public class UsersRepository extends BaseItemsRepository<User>
{
    public List<User> get(UsersInput input)
    {
        var searchBuilder = new UsersSearchBuilder(input);
        var stmt = "FROM User AS t " + "left join fetch t.role " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        return selectAll(stmt, User.class, searchBuilder.getParameterList());
    }

    private class UsersSearchBuilder extends SearchBuilder
    {
        UsersSearchBuilder(UsersInput input)
        {
            if (input != null)
            {
                if ((input.getUserId() > 0))
                {
                    add("and t.role = :roleId ", "roleId", input.getRoleId());
                }
                if ((input.getUserName() != null) && (!input.getUserName().isEmpty()))
                {
                    add("and t.username = :username ", "username", "%" + input.getUserName() + "%");
                }
                if ((input.getRoleId() > 0))
                {
                    add("and t.role = :roleId ", "roleId", input.getRoleId());
                }
                if ((!input.getFirstName().isEmpty()) && (input.getFirstName() != null))
                {
                    add("and t.firstName = :firstName ", "firstName", input.getFirstName());
                }
                if ((!input.getEmail().isEmpty()) && (input.getEmail() != null))
                {
                    add("and t.email = :email ", "email", input.getEmail());
                }
                if ((!input.getPassword().isEmpty()) && (input.getPassword() != null))
                {
                    add("and t.password = :password ", "password", input.getPassword());
                }
            }
        }
    }
}
