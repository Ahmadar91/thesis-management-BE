package se.lnu.thesis_mangment.repositories.base;


import org.springframework.transaction.annotation.Transactional;
import se.lnu.thesis_mangment.repositories.query.Parameter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class BaseRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    public <T> List<T> selectAll(String hql, Class<T> cls)
    {
        return selectAll(hql, cls, -1, -1);
    }

    public <T> List<T> selectAll(String hql, Class<T> cls, List<Parameter> parameterList)
    {
        return selectAll(hql, cls, -1, -1, toArray(parameterList));
    }

    public <T> List<T> selectAll(String hql, Class<T> cls, int pageIndex, int pageSize, List<Parameter> parameterList)
    {
        return selectAll(hql, cls, pageIndex, pageSize, toArray(parameterList));
    }

    private Parameter[] toArray(List<Parameter> parameterList)
    {
        Parameter[] parameters = new Parameter[parameterList.size()];
        for (int i = 0; i < parameterList.size(); ++i)
        {
            parameters[i] = parameterList.get(i);
        }
        return parameters;
    }

    public <T> List<T> selectAll(String hql, Class<T> cls, Parameter... args)
    {
        return selectAll(hql, cls, -1, -1, args);
    }

    public <T> List<T> selectAll(String hql, Class<T> cls, int pageIndex, int pageSize, Parameter... args)
    {
        TypedQuery<T> query = entityManager.createQuery(hql, cls);
        for (Parameter arg : args)
        {
            query.setParameter(arg.getName(), arg.getValue());
        }
        if (pageSize > 0)
        {
            query.setFirstResult(pageIndex * pageSize);
            query.setMaxResults(pageSize);
        }
        return query.getResultList();
    }

    @Transactional
    public <T> T save(T t)
    {
        entityManager.persist(t);
        return t;
    }

    @Transactional
    public <T> T update(T t)
    {
        entityManager.merge(t);
        return t;
    }


    public <T> List<T> saveAll(List<T> list)
    {
        int i = 0;
        for (T t : list)
        {
            save(t);
            i++;
            int BATCH_SIZE = 100;
            if (i % BATCH_SIZE == 0)
            {
                entityManager.clear();
                entityManager.flush();
            }
        }
        entityManager.clear();
        entityManager.flush();

        return list;
    }

    public <T> T select(String hql, Class<T> cls)
    {
        return select(hql, cls, new Parameter[0]);
    }

    public <T> T select(String hql, Class<T> cls, List<Parameter> parameterList)
    {
        return select(hql, cls, toArray(parameterList));
    }

    public <T> T select(String hql, Class<T> cls, Parameter... args)
    {
        TypedQuery<T> query = entityManager.createQuery(hql, cls);
        for (Parameter arg : args)
        {
            query.setParameter(arg.getName(), arg.getValue());
        }
        return query.getSingleResult();
    }


    public int update(String hql, Parameter... args)
    {
        Query query = entityManager.createQuery(hql);
        for (Parameter arg : args)
        {
            query.setParameter(arg.getName(), arg.getValue());
        }
        return query.executeUpdate();
    }
}