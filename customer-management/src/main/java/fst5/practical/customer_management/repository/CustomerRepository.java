package fst5.practical.customer_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fst5.practical.customer_management.entity.Customer;

/**
 * Repository used for database operations related to customers.
 *
 * <p>
 * JpaRepository provides standard CRUD operations.
 * </p>
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}