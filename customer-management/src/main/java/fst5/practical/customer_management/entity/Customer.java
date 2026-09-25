package fst5.practical.customer_management.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing a customer.
 *
 * <p>
 * This class is mapped to the customer table
 * using JPA and Hibernate.
 * </p>
 */
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    /**
     * Unique ID of the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * First name of the customer.
     */
    private String firstName;

    /**
     * Last name of the customer.
     */
    private String lastName;

    /**
     * Date of birth of the customer.
     */
    private LocalDate dateOfBirth;

    /**
     * Mobile number of the customer.
     */
    private String mobile;

    /**
     * First address of the customer.
     */
    private String address1;

    /**
     * Second address of the customer.
     */
    private String address2;

    /**
     * Age of the customer.
     */
    private int age;

    /**
     * Gender of the customer.
     */
    private String gender;

    /**
     * Email address of the customer.
     */
    private String email;
}