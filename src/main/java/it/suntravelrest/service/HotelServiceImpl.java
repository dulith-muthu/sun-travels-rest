package it.suntravelrest.service;

import it.suntravelrest.model.Hotel;
import it.suntravelrest.repository.HotelRepository;
import it.suntravelrest.service.base.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService
{
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository)
    {
        this.hotelRepository= hotelRepository;
    }

    @Override public Hotel findHotelById( Long id )
    {
        return hotelRepository.findById( id ).get();
    }

    @Override public List<Hotel> findAllHotels()
    {
        return hotelRepository.findAll();
    }

    @Override public Hotel addHotel(Hotel hotel)
    {
        return hotelRepository.save( hotel );
    }
}