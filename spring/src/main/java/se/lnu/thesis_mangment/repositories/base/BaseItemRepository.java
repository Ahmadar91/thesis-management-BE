package se.lnu.thesis_mangment.repositories.base;


import org.springframework.stereotype.Repository;
import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;
import se.lnu.thesis_mangment.repositories.query.Parameter;

/**
 * The type Base item repository.
 *
 * @param <T> the type parameter
 */
@Repository
public class BaseItemRepository<T> extends BaseRepository
{

    /**
     * Get t.
     *
     * @param id  the id
     * @param cls the cls
     * @return the t
     */
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