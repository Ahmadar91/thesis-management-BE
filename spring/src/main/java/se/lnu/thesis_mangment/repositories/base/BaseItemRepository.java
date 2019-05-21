package se.lnu.thesis_mangment.repositories.base;


import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.repositories.query.Parameter;

@Repository
public class BaseItemRepository<T> extends BaseRepository
{

    public T get(long id, Class<T> cls)
    {
        var item = select("FROM " + cls.getName() + " AS t " + "where " + "and t.id = :id", cls, new Parameter<>("id", id));
        if (item == null)
        {
            throw new ResourceNotFoundException("Item not found");
        }
        return item;
    }

}