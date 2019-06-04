package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import javax.transaction.Transactional;

/**
 * The type User services.
 */
@Service
public class UserServices
{
    @Autowired
    private UsersRepository repository;

    /**
     * Get user.
     *
     * @param input the input
     * @return the user
     */
    public User get(UsersDTO input)
    {
        return repository.getUser(input);
    }

    /**
     * Add.
     *
     * @param user the user
     */
    @Transactional
    public void add(User user)
    {
        repository.add(user);
    }


    /**
     * Update.
     *
     * @param item the item
     */
    public void update(User item)
    {
        repository.update(item);
    }

    /**
     * Find by username and password user.
     *
     * @param username the username
     * @return the user
     */
    public User findByUsernameAndPassword(String username)
    {
        return repository.findByUsername(username);
    }

}