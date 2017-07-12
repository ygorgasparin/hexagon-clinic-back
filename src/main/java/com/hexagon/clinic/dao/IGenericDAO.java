package com.hexagon.clinic.dao;

import com.hexagon.clinic.model.BaseModel;

import java.util.List;

/**
 * Generic class to save object on database. Contain the most commons method(CRUD),
 * anything more complex of that should be implemented on your respectively class
 *
 * @param <T>
 */
public interface IGenericDAO<T extends BaseModel> {

    /**
     * Find generic object by you id
     *
     * @param id
     * @return
     */
    T findById(final long id);

    /**
     * Find the object using the {@link FilterStruct} and {@link OrderStruct} to build the query
     *
     * @param filterStruct
     * @param orderStruct
     * @return
     */
    List<T> findAll(FilterStruct filterStruct, OrderStruct orderStruct);

    /**
     * Create the object if not exits
     *
     * @param entity
     * @return
     */
    T create(final T entity);

    /**
     * Update all object information's. The object must have an valid id
     *
     * @param entity
     * @return
     */
    T update(final T entity);

    /**
     * Delete the object from database. The object must have an valid id
     *
     * @param entity
     */
    void delete(final T entity);

    /**
     * Delete the object with this id. Should be informed an valid id
     *
     * @param entityId
     */
    void deleteById(final long entityId);

}
