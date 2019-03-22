package it.suntravelrest.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomRequirmentsPair implements Serializable
{
    int numberOfAdults;
    int numberOfRooms;
}
