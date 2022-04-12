package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.casestudy.validation.EmailUnique;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {
    // These names must match the names in the form.

    // This id will be null in case of "create". It will be populated with the userid in case of "edit".
    private Integer id;

    @NotBlank (message = "Email is required.")
    @EmailUnique (message = "Email already exists in database.")
    @Pattern (regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Email format is invalid.")
    private String email;

    @NotBlank (message = "First Name is required.")
    private String firstName;

    @NotBlank (message = "Last Name is required.")
    private String lastName;

    @NotBlank (message = "Password is required.")
    @Length(min = 3, max = 15)
    private String password;

    @NotBlank (message = "Confirm Password is required.")
    @Length (min = 3, max = 15)
    private String cpassword;

    @AssertTrue (message = "Check box is required.")
    private boolean checkbox;
}
/* Do not use an entity object as your form bean. It has to map to a table. Your form may have fields which do not go
   in the database. */