package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.LoginInput;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.model.UsersInput;
import se.lnu.thesis_mangment.repositories.UsersRepository;

import javax.transaction.Transactional;
import java.util.List;

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

//    public Long count()
//    {
//        return repository.count(User.class);
//    }
//
//    public User create(User item)
//    {
//        return repository.save(item);
//    }
//
//    public List<Long> delete(List<Long> list)
//    {
//        repository.delete(list, User.class);
//        return list;
//    }
}
