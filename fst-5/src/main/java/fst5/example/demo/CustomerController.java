package fst5.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for performing CRUD operations on customers.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

        private final CustomerRepository customerRepository;

        /**
         * Constructor injection for CustomerRepository.
         */
        public CustomerController(CustomerRepository customerRepository) {
                this.customerRepository = customerRepository;
        }

        /**
         * CREATE CUSTOMER
         *
         * POST /customers
         */
        @PostMapping
        public Customer createCustomer(
                        @RequestBody Customer customer) {

                return customerRepository.save(customer);
        }

        /**
         * READ ALL CUSTOMERS
         *
         * GET /customers
         */
        @GetMapping
        public List<Customer> getAllCustomers() {

                return customerRepository.findAll();
        }

        /**
         * READ CUSTOMER BY ID
         *
         * GET /customers/{id}
         */
        @GetMapping("/{id}")
        public Customer getCustomerById(
                        @PathVariable Long id) {

                return customerRepository
                                .findById(id)
                                .orElse(null);
        }

        /**
         * UPDATE CUSTOMER
         *
         * PUT /customers/{id}
         */
        @PutMapping("/{id}")
        public Customer updateCustomer(
                        @PathVariable Long id,
                        @RequestBody Customer customer) {

                Customer existingCustomer = customerRepository
                                .findById(id)
                                .orElse(null);

                if (existingCustomer == null) {
                        return null;
                }

                existingCustomer.setFirstName(
                                customer.getFirstName());

                existingCustomer.setLastName(
                                customer.getLastName());

                existingCustomer.setDateOfBirth(
                                customer.getDateOfBirth());

                existingCustomer.setMobile(
                                customer.getMobile());

                existingCustomer.setAddress1(
                                customer.getAddress1());

                existingCustomer.setAddress2(
                                customer.getAddress2());

                existingCustomer.setAge(
                                customer.getAge());

                existingCustomer.setGender(
                                customer.getGender());

                existingCustomer.setEmail(
                                customer.getEmail());

                return customerRepository.save(existingCustomer);
        }

        /**
         * DELETE CUSTOMER
         *
         * DELETE /customers/{id}
         */
        @DeleteMapping("/{id}")
        public String deleteCustomer(
                        @PathVariable Long id) {

                if (!customerRepository.existsById(id)) {
                        return "Customer with ID " + id + " not found";
                }

                customerRepository.deleteById(id);

                return "Customer deleted successfully";
        }
}