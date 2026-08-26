package fst5.example.demo.service;

import java.util.List;

/**
 * Generic service interface that provides common CRUD operations.
 *
 * @param <D> DTO type
 * @param <I> ID type
 */
public interface GenericService<D, I> {

    /**
     * Creates a new record.
     *
     * @param dto data to create
     * @return created record
     */
    D create(D dto);

    /**
     * Returns all records.
     *
     * @return list of records
     */
    List<D> getAll();

    /**
     * Returns a record by ID.
     *
     * @param id record ID
     * @return record
     */
    D getById(I id);

    /**
     * Updates an existing record.
     *
     * @param id  record ID
     * @param dto updated data
     * @return updated record
     */
    D update(I id, D dto);

    /**
     * Deletes a record.
     *
     * @param id record ID
     */
    void delete(I id);
}