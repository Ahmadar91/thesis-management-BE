package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersDTO;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import javax.transaction.Transactional;

@Service
public class UserServices
{
    @Autowired
    private UsersRepository repository;

    public User get(UsersDTO input)
    {
        return repository.getUser(input);
    }

    @Transactional
    public void add(User user)
    {
        repository.add(user);
    }


    public void update(User item)
    {
        repository.update(item);
    }

    public User findByUsernameAndPassword(String username)
    {
        return repository.findByUsername(username);
    }

}