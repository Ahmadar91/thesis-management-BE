package se.lnu.thesis_mangment.repositories;

import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.model.Role;
import se.lnu.thesis_mangment.repositories.base.BaseItemsRepository;

import java.util.List;

/**
 * The type Roles repository.
 */
@Repository
public class RolesRepository extends BaseItemsRepository<Role>
{
    /**
     * Get list.
     *
     * @return the list
     */
    public List<Role> get()
    {
        return selectAll("FROM Role AS t " + " ", Role.class);
    }
}
