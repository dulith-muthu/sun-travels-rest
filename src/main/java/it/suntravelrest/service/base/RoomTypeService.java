package it.suntravelrest.service.base;

import it.codegen.tbx.accommodationmanager.Room;
import it.suntravelrest.model.Hotel;
import it.suntravelrest.model.RoomType;

import java.util.List;

public interface RoomTypeService
{
    List<RoomType> getAllRoomTypes();

    List<RoomType> getAllRoomTypesByHotelId( Hotel id);

    List<RoomType> getAllByNumberOfAdults(int numberOfAdults);

    RoomType addNewRoomType(RoomType roomType);
}
