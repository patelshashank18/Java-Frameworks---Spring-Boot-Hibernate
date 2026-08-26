package fst5.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fst5.example.demo.dto.CustomerDto;
import fst5.example.demo.entity.Customer;
import fst5.example.demo.repository.CustomerRepository;
import fst5.example.demo.service.CustomerService;

/**
 * Implementation of customer service operations.
 *
 * <p>
 * This class contains the business logic for customer CRUD operations.
 * </p>
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Creates the customer service.
     *
     * @param customerRepository customer repository
     */
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Creates a new customer.
     *
     * @param dto customer data
     * @return created customer
     */
    @Override
    public CustomerDto create(CustomerDto dto) {

        Customer customer = convertToEntity(dto);

        Customer savedCustomer = customerRepository.save(customer);

        return convertToDto(savedCustomer);
    }

    /**
     * Returns all customers.
     *
     * @return list of customers
     */
    @Override
    public List<CustomerDto> getAll() {

        return customerRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    /**
     * Returns a customer by ID.
     *
     * @param id customer ID
     * @return customer data
     */
    @Override
    public CustomerDto getById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Customer not found"));

        return convertToDto(customer);
    }

    /**
     * Updates an existing customer.
     *
     * @param id  customer ID
     * @param dto updated customer data
     * @return updated customer
     */
    @Override
    public CustomerDto update(
            Long id,
            CustomerDto dto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Customer not found"));

        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setMobile(dto.getMobile());
        customer.setAddress1(dto.getAddress1());
        customer.setAddress2(dto.getAddress2());
        customer.setAge(dto.getAge());
        customer.setGender(dto.getGender());
        customer.setEmail(dto.getEmail());

        Customer updatedCustomer = customerRepository.save(customer);

        return convertToDto(updatedCustomer);
    }

    /**
     * Deletes a customer by ID.
     *
     * @param id customer ID
     */
    @Override
    public void delete(Long id) {

        customerRepository.deleteById(id);
    }

    /**
     * Converts DTO into entity.
     *
     * <p>
     * The ID is not copied because the database generates
     * the ID automatically.
     * </p>
     *
     * @param dto customer DTO
     * @return customer entity
     */
    private Customer convertToEntity(CustomerDto dto) {

        Customer customer = new Customer();

        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setMobile(dto.getMobile());
        customer.setAddress1(dto.getAddress1());
        customer.setAddress2(dto.getAddress2());
        customer.setAge(dto.getAge());
        customer.setGender(dto.getGender());
        customer.setEmail(dto.getEmail());

        return customer;
    }

    /**
     * Converts entity into DTO.
     *
     * <p>
     * The ID is copied so that the frontend can use the
     * customer ID for update and delete operations.
     * </p>
     *
     * @param customer customer entity
     * @return customer DTO
     */
    private CustomerDto convertToDto(Customer customer) {

        CustomerDto dto = new CustomerDto();

        /*
         * Copy the database-generated ID.
         */
        dto.setId(customer.getId());

        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setDateOfBirth(customer.getDateOfBirth());
        dto.setMobile(customer.getMobile());
        dto.setAddress1(customer.getAddress1());
        dto.setAddress2(customer.getAddress2());
        dto.setAge(customer.getAge());
        dto.setGender(customer.getGender());
        dto.setEmail(customer.getEmail());

        return dto;
    }
}
