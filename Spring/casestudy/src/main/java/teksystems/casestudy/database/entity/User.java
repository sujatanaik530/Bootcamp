package teksystems.casestudy.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column (name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column (name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column (name = "password", nullable = false, length = 45)
    private String password;

    @Column (name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}
