package fst5.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fst5.example.demo.entity.Customer;

/**
 * Repository used for database operations related to customers.
 *
 * <p>
 * JpaRepository provides standard CRUD operations.
 * </p>
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
