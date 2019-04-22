package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.repositories.roles.RolesRepository;
import se.lnu.thesis_mangment.model.Role;

import java.util.List;

@Service
public class RolesService
{
    @Autowired
    private RolesRepository repository;

    public List<Role> get()
    {
        return repository.get();
    }

    public Long count()
    {
        return repository.count(Role.class);
    }


    public Role create(Role item)
    {
        return repository.save(item);
    }

    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Role.class);
        return list;
    }
}
