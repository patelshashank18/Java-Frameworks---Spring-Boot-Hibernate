package fst5.practical.customer_management.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to receive and return customer data.
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
     * Primary address of the customer.
     */
    @NotBlank(message = "{customer.address1.required}")
    private String address1;

    /**
     * Secondary address of the customer.
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
