package it.suntravelrest.service.base;

import it.suntravelrest.model.Hotel;
import it.suntravelrest.model.RoomType;

import java.util.List;

public interface HotelService
{
    Hotel findHotelById(Long id);

    List<Hotel> findAllHotels();

    Hotel addHotel(Hotel hotel);
}
