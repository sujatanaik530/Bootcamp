package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterFormBean {
    // These names must match the names in the form.
    // This id will be null in case of "create". It will be populated with the userid in case of "edit".
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String cpassword;
}
/* Do not use an entity object as your form bean. It has to map to a table. Your form may have fields which do not go
   in the database. */