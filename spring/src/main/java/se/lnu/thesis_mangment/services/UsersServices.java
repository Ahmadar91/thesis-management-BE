package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import java.util.List;

/**
 * The type Users services.
 */
@Service
public class UsersServices
{
    @Autowired
    private UsersRepository repository;

    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<User> get(UsersDTO input)
    {
        return repository.get(input);
    }

    /**
     * Count long.
     *
     * @return the long
     */
    public Long count()
    {
        return repository.count(User.class);
    }

    /**
     * Create user.
     *
     * @param item the item
     * @return the user
     */
    public User create(User item)
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
        repository.delete(list, User.class);
        return list;
    }
}
