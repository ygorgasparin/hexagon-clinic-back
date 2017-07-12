package com.hexagon.clinic.dao;

import com.hexagon.clinic.model.BaseModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;


public abstract class GenericDAO<T extends BaseModel> implements IGenericDAO<T> {

    @PersistenceContext
    EntityManager entityManager;

    public abstract Class<T> getClazz();

    @Override
    public T findById(long id) {
        return entityManager.find(getClazz(), id);
    }

    @Override
    public List<T> findAll(FilterStruct filterStruct, OrderStruct orderStruct) {

        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cBuilder.createQuery(getClazz());
        Root<T> from = query.from(getClazz());

        query = buildFilter(from, cBuilder, query, filterStruct);
        query = buildOrder(from, cBuilder, query, orderStruct);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(long entityId) {
        T entity = findById(entityId);
        delete(entity);
    }

    protected CriteriaQuery<T> buildFilter(Root<T> from, CriteriaBuilder cBuilder, CriteriaQuery<T> query, FilterStruct filterStruct) {
        if (filterStruct == null || filterStruct.getPathFilter() == null)
            return query;

        EntityType<T> type = entityManager.getMetamodel().entity(getClazz());
        Path<String> path = from.get(type.getDeclaredSingularAttribute(filterStruct.getPathFilter(), String.class));
        Predicate predicate = cBuilder.like(cBuilder.lower(path), "%" + filterStruct.getFilterValue().toLowerCase() + "%");
        return query.where(predicate);
    }

    protected CriteriaQuery<T> buildOrder(Root<T> from, CriteriaBuilder cBuilder, CriteriaQuery<T> query, OrderStruct orderStruct) {

        if (orderStruct == null || orderStruct.getPathOrder() == null)
            return query;

        Path<Object> objectPath = from.get(orderStruct.getPathOrder());
        if (orderStruct.getDescOrder())
            return query.orderBy(cBuilder.desc(objectPath));
        else
            return query.orderBy(cBuilder.asc(objectPath));

    }
}
