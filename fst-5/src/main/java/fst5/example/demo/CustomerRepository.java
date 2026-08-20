package fst5.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing database operations
 * on Customer entities.
 *
 * <p>
 * JpaRepository provides built-in CRUD operations such as
 * save(), findAll(), findById(), and deleteById().
 * </p>
 */
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

}