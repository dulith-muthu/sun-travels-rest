package it.suntravelrest.config;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SearchCriteria implements Serializable
{
    // Number of Rooms, Number of Adults
    List<RoomRequirmentsPair> roomRequirments;
    int numberOfNights;
    Date startDate;
}


