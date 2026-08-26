package fst5.example.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to receive and return customer data.
 *
 * <p>
 * Validation rules are defined in this class before
 * customer data is processed by the service layer.
 * </p>
 */
@Getter
@Setter
public class CustomerDto {

    /**
     * Unique ID of the customer.
     */
    private Long id;

    /**
     * First name of the customer.
     */
    @NotBlank(message = "{customer.firstName.required}")
    @Size(max = 50, message = "{customer.firstName.size}")
    private String firstName;

    /**
     * Last name of the customer.
     */
    @NotBlank(message = "{customer.lastName.required}")
    @Size(max = 50, message = "{customer.lastName.size}")
    private String lastName;

    /**
     * Date of birth of the customer.
     */
    @NotNull(message = "{customer.dateOfBirth.required}")
    @Past(message = "{customer.dateOfBirth.past}")
    private LocalDate dateOfBirth;

    /**
     * Mobile number of the customer.
     */
    @NotBlank(message = "{customer.mobile.required}")
    @Size(max = 15, message = "{customer.mobile.size}")
    private String mobile;

    /**
     * First address of the customer.
     */
    @NotBlank(message = "{customer.address1.required}")
    private String address1;

    /**
     * Second address of the customer.
     */
    private String address2;

    /**
     * Age of the customer.
     */
    @PositiveOrZero(message = "{customer.age.invalid}")
    private int age;

    /**
     * Gender of the customer.
     */
    @NotBlank(message = "{customer.gender.required}")
    private String gender;

    /**
     * Email address of the customer.
     */
    @NotBlank(message = "{customer.email.required}")
    @Email(message = "{customer.email.invalid}")
    private String email;
}