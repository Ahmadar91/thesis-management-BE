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
        //      var stmt = "FROM User AS t " + "left join fetch t.role " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        var stmt = "FROM User AS t " + "where " + "t.deleted = 0 " + searchBuilder.getStatement();
        var res = selectAll(stmt, User.class, searchBuilder.getParameterList());
        return res;
    }

    private class UsersSearchBuilder extends SearchBuilder
    {
        UsersSearchBuilder(UsersInput input)
        {
            if (input != null)
            {
                if ((input.getId() > 0))
                {
                    add("and t.id = :id ", "id", input.getId());
                }
                if ((input.getUsername() != null) && (!input.getUsername().isEmpty()))
                {
                    add("and t.username = :username ", "username", input.getUsername());
                }
                if ((input.getRoleId() > 0))
                {
                    add("and t.roleId = :roleId ", "roleId", input.getRoleId());
                }
                if ((input.getFirstName() != null) && (!input.getFirstName().isEmpty()))
                {
                    add("and t.firstName = :firstName ", "firstName", input.getFirstName());
                }
                if ((input.getEmail() != null) && (!input.getEmail().isEmpty()))
                {
                    add("and t.email = :email ", "email", input.getEmail());
                }
//                if ((input.getPassword() != null) && (!input.getPassword().isEmpty()))
//                {
//                    add("and t.password = :password ", "password", input.getPassword());
//                }
            }
        }
    }
}
