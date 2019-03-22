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
@Table(name = "NH_HOTEL")
public class Hotel
{
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "STAR_RATE", nullable = true)
    private int starRate;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "COUNTRY", nullable = true)
    private String country;

    @Column(name = "IS_ACTIVE", nullable = true)
    private String isActive;

    @Column(name = "CREATED_AT", nullable = true)
    private Date createdAt;
}
