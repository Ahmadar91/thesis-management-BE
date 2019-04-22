package se.lnu.thesis_mangment.repositories.roles;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Role;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;

import java.util.List;

@Repository
public class RolesRepository extends BaseItemsRepository<Role>
{
    public List<Role> get()
    {
        return selectAll("FROM Role AS t " + " ", Role.class);
    }
}
