package se.lnu.thesis_mangment.repositories.base;


import org.springframework.transaction.annotation.Transactional;
import se.lnu.thesis_mangment.repositories.query.Parameter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Base repository.
 */
public class BaseRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Select all list.
     *
     * @param <T> the type parameter
     * @param hql the hql
     * @param cls the cls
     * @return the list
     */
    public <T> List<T> selectAll(String hql, Class<T> cls)
    {
        return selectAll(hql, cls, -1, -1);
    }

    /**
     * Select all list.
     *
     * @param <T>           the type parameter
     * @param hql           the hql
     * @param cls           the cls
     * @param parameterList the parameter list
     * @return the list
     */
    public <T> List<T> selectAll(String hql, Class<T> cls, List<Parameter> parameterList)
    {
        return selectAll(hql, cls, -1, -1, toArray(parameterList));
    }

    /**
     * Select all list.
     *
     * @param <T>           the type parameter
     * @param hql           the hql
     * @param cls           the cls
     * @param pageIndex     the page index
     * @param pageSize      the page size
     * @param parameterList the parameter list
     * @return the list
     */
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

    /**
     * Select all list.
     *
     * @param <T>  the type parameter
     * @param hql  the hql
     * @param cls  the cls
     * @param args the args
     * @return the list
     */
    public <T> List<T> selectAll(String hql, Class<T> cls, Parameter... args)
    {
        return selectAll(hql, cls, -1, -1, args);
    }

    /**
     * Select all list.
     *
     * @param <T>       the type parameter
     * @param hql       the hql
     * @param cls       the cls
     * @param pageIndex the page index
     * @param pageSize  the page size
     * @param args      the args
     * @return the list
     */
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

    /**
     * Save t.
     *
     * @param <T> the type parameter
     * @param t   the t
     * @return the t
     */
    @Transactional
    public <T> T save(T t)
    {
        entityManager.persist(t);
        return t;
    }

    /**
     * Save all list.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the list
     */
    public <T> List<T> saveAll(List<T> list)
    {
        int i = 0;
        for (T t : list)
        {
            entityManager.persist(t);
            i++;
            int batchSize = 100;
            if (i % batchSize == 0)
            {
                entityManager.clear();
                entityManager.flush();
            }
        }
        entityManager.clear();
        entityManager.flush();

        return list;
    }

    /**
     * Select t.
     *
     * @param <T> the type parameter
     * @param hql the hql
     * @param cls the cls
     * @return the t
     */
    public <T> T select(String hql, Class<T> cls)
    {
        return select(hql, cls, new Parameter[0]);
    }

    /**
     * Select t.
     *
     * @param <T>           the type parameter
     * @param hql           the hql
     * @param cls           the cls
     * @param parameterList the parameter list
     * @return the t
     */
    public <T> T select(String hql, Class<T> cls, List<Parameter> parameterList)
    {
        return select(hql, cls, toArray(parameterList));
    }

    /**
     * Select t.
     *
     * @param <T>  the type parameter
     * @param hql  the hql
     * @param cls  the cls
     * @param args the args
     * @return the t
     */
    public <T> T select(String hql, Class<T> cls, Parameter... args)
    {
        TypedQuery<T> query = entityManager.createQuery(hql, cls);
        for (Parameter arg : args)
        {
            query.setParameter(arg.getName(), arg.getValue());
        }
        return query.getSingleResult();
    }

    /**
     * Update t.
     *
     * @param <T> the type parameter
     * @param t   the t
     * @return the t
     */
    @Transactional
    public <T> T update(T t)
    {
        entityManager.merge(t);
        return t;
    }

    /**
     * Update int.
     *
     * @param hql  the hql
     * @param args the args
     * @return the int
     */
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