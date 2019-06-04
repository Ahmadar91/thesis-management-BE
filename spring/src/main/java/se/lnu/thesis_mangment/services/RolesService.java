package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Role;
import se.lnu.thesis_mangment.repositories.RolesRepository;

import java.util.List;

/**
 * The type Roles service.
 */
@Service
public class RolesService
{
    @Autowired
    private RolesRepository repository;

    /**
     * Get list.
     *
     * @return the list
     */
    public List<Role> get()
    {
        return repository.get();
    }

    /**
     * Count long.
     *
     * @return the long
     */
    public Long count()
    {
        return repository.count(Role.class);
    }

    /**
     * Create role.
     *
     * @param item the item
     * @return the role
     */
    public Role create(Role item)
    {
        return repository.save(item);
    }

    /**
     * Delete list.
     *
     * @param list the list
     * @return the list
     */
    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Role.class);
        return list;
    }
}
