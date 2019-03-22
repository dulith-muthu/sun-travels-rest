package it.suntravelrest.model;

import it.codegen.CGTimestamp;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "NH_CONTRACT")
public class Contract implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Column(name = "MARKUP", nullable = false)
    private double markup;

    @ManyToOne
    @JoinColumn( name = "NH_HOTEL_ID", nullable = false, foreignKey = @ForeignKey (name="NH_CONTRACT_FK1"))
    @MapsId("id")
    private Hotel hotelId;

    @Column(name = "IS_ACTIVE", nullable = true)
    private boolean isActive;

    @Column(name = "CREATED_AT", nullable = true)
    private Date createdAt;
}
