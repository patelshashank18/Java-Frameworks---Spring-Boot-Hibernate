package fst5.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import fst5.example.demo.dto.CustomerDto;
import fst5.example.demo.service.CustomerService;

/**
 * REST controller used to manage customer operations.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

        private final CustomerService customerService;

        /**
         * Creates the customer controller.
         *
         * @param customerService customer service
         */
        public CustomerController(CustomerService customerService) {
                this.customerService = customerService;
        }

        /**
         * Returns all customers.
         *
         * @return list of customers
         */
        @GetMapping
        public ResponseEntity<List<CustomerDto>> getAll() {

                return ResponseEntity.ok(
                                customerService.getAll());
        }

        /**
         * Returns one customer by ID.
         *
         * @param id customer ID
         * @return customer details
         */
        @GetMapping("/{id}")
        public ResponseEntity<CustomerDto> getById(
                        @PathVariable Long id) {

                return ResponseEntity.ok(
                                customerService.getById(id));
        }

        /**
         * Creates a new customer.
         *
         * @param customerDto customer data
         * @return created customer
         */
        @PostMapping
        public ResponseEntity<CustomerDto> create(
                        @Valid @RequestBody CustomerDto customerDto) {

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(customerService.create(customerDto));
        }

        /**
         * Updates an existing customer.
         *
         * @param id          customer ID
         * @param customerDto updated customer data
         * @return updated customer
         */
        @PutMapping("/{id}")
        public ResponseEntity<CustomerDto> update(
                        @PathVariable Long id,
                        @Valid @RequestBody CustomerDto customerDto) {

                return ResponseEntity.ok(
                                customerService.update(
                                                id,
                                                customerDto));
        }

        /**
         * Deletes a customer.
         *
         * @param id customer ID
         * @return empty response
         */
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(
                        @PathVariable Long id) {

                customerService.delete(id);

                return ResponseEntity.noContent().build();
        }
}