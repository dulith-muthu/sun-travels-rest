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
@Table(name = "NH_CONTRACT_ROOM")
public class ContractRoom
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn( name = "NH_ROOM_TYPE_ID", nullable = false, foreignKey = @ForeignKey(name="NH_CONTRACT_ROOM_FK2"))
    @MapsId("id")
    private RoomType roomType;

    @ManyToOne
    @JoinColumn( name = "NH_CONTRACT_ID", nullable = false, foreignKey = @ForeignKey(name="NH_CONTRACT_ROOM_FK1"))
    @MapsId("id")
    private Contract contractId;

    @Column(name = "NO_OF_ROOMS", nullable = false)
    private int noOfRooms;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "CREATED_AT", nullable = true)
    private Date createdAt;
}
