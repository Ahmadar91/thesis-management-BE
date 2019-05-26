package se.lnu.thesis_mangment.repositories.base;


import org.springframework.transaction.annotation.Transactional;
import se.lnu.thesis_mangment.repositories.query.Parameter;

import java.util.List;

public abstract class BaseItemsRepository<T> extends BaseRepository
{
    private static final String AS = " AS t ";
    public List<T> getIn(List<Long> list, Class<T> cls)
    {
        return selectAll("FROM " + cls.getName() + AS + "where " + "(t.id in (:ids))", cls, new Parameter<>("ids", list));
    }

    public Long count(Class<T> cls)
    {
        return select("SELECT count(*) FROM " + cls.getName() + AS, Long.class);
    }

    @Transactional
    public void delete(List<Long> list, Class<T> cls)
    {
        update("UPDATE " + cls.getName() + AS + "set t.deleted = t.id " + "WHERE " + "t.id IN (:ids)", new Parameter<>("ids", list));
    }

    //added 21/5
    @Transactional
    public void updateItem(T item, Class<T> cls)
    {
        update("UPDATE " + cls.getName() + AS + "set t.deleted = t.id " + "WHERE " + "t.id IN (:ids)", new Parameter<>("ids", item));
    }
}