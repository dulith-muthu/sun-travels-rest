package it.suntravelrest.config;

import lombok.Data;

@Data
public class SearchResultLine
{
    private long contractRoomTypeId;
    private long roomTypeId;
    private String roomTypeName;
    private double price;
    private int noOfAdults;
    private int noOfRooms;
    private double totalLinePrice;
}
