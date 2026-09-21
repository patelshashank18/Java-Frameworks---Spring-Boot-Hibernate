package fst5.practical.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fst5.practical.customermanagement.entity.Customer;

/**
 * Repository used for database operations related to customers.
 *
 * <p>
 * JpaRepository provides standard CRUD operations.
 * </p>
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}