package it.suntravelrest.service;

import it.suntravelrest.model.Hotel;
import it.suntravelrest.model.RoomType;
import it.suntravelrest.repository.RoomTypeRepository;
import it.suntravelrest.service.base.RoomTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
@Service
public class RoomTypeServiceImpl implements RoomTypeService
{
    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl( RoomTypeRepository roomTypeRepository )
    {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override public List<RoomType> getAllRoomTypes(){  return roomTypeRepository.findAll(); }

    @Override public List<RoomType> getAllRoomTypesByHotelId( Hotel id)
    {
        return roomTypeRepository.findByAndHotelIdIs(id);
    }

    @Override public List<RoomType> getAllByNumberOfAdults( int numberOfAdults )
    {
        return roomTypeRepository.findByNoOfAdults( numberOfAdults );
    }

    @Override public RoomType addNewRoomType( RoomType roomType )
    {
        roomType.setCreatedAt( new Date() );
        return roomTypeRepository.save( roomType );
    }



}
