package it.suntravelrest.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "NH_USER")
public class User
{
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_NAME", nullable = false, length = 20)
    private String userName;

    @Column(name = "SALT", nullable = false, length = 20)
    private String salt;

    @Column(name = "PASSWORD", nullable = false, length = 50)
    private String password;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "IS_ACTIVE", nullable = true)
    private String isActive;

    @Column(name = "CREATED_AT", nullable = true)
    private Date createdAt;
}
