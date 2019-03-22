package it.suntravelrest.model;

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
import java.util.Date;

@Data
@Entity
@Table(name = "NH_ROOM_TYPE")
public class RoomType
{
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn( name = "NH_HOTEL_ID", nullable = false, foreignKey = @ForeignKey(name = "NH_ROOM_TYPE_FK1"))
    @MapsId("id")
    private Hotel hotelId;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "NO_OF_ADULTS", nullable = true)
    private int noOfAdults;

    @Column(name = "IS_ACTIVE", nullable = true)
    private boolean isActive;

    @Column(name = "CREATED_AT", nullable = true)
    private Date createdAt;
}
