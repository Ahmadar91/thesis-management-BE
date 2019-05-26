package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import javax.transaction.Transactional;

@Service
public class UserServices
{
    @Autowired
    private UsersRepository repository;

    public User get(UsersInput input)
    {
        return repository.getUser(input);
    }

    @Transactional
    public void add(User user)
    {
        repository.add(user);
    }
}
