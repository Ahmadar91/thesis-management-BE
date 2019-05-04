package se.lnu.thesis_mangment.repositories.base;


import org.springframework.transaction.annotation.Transactional;
import se.lnu.thesis_mangment.repositories.query.Parameter;

import java.util.List;

public abstract class BaseItemsRepository<T> extends BaseRepository
{

    public List<T> getIn(List<Long> list, Class<T> cls)
    {
        return selectAll("FROM " + cls.getName() + " AS t " + "where " + "(t.id in (:ids))", cls, new Parameter<>("ids", list));
    }

    public Long count(Class<T> cls)
    {
        return select("SELECT count(*) FROM " + cls.getName() + " AS t ", Long.class);
    }

    @Transactional
    public void delete(List<Long> list, Class<T> cls)
    {
        update("UPDATE " + cls.getName() + " AS t " + "set t.deleted = t.id " + "WHERE " + "t.id IN (:ids)", new Parameter<>("ids", list));
    }
}