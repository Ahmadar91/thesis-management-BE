package se.lnu.thesis_mangment.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import static java.util.Collections.emptyList;

/**
 * The type User details service.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private UsersRepository repository;

    /**
     * Instantiates a new User details service.
     *
     * @param usersRepository the users repository
     */
    public UserDetailsServiceImpl(UsersRepository usersRepository)
    {
        this.repository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        var applicationUser = repository.findByUsername(username);
        if (applicationUser == null)
        {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}