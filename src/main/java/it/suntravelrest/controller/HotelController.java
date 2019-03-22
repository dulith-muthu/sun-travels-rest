package it.suntravelrest.controller;

import io.swagger.annotations.ApiOperation;
import it.suntravelrest.model.Hotel;
import it.suntravelrest.service.base.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(HotelController.BASE_URL)
public class HotelController
{
    public static final String BASE_URL = "/api/v1/hotel";
    private final HotelService hotelService;

    public HotelController( HotelService hotelService )
    {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation( value = "Get all hotels")
    List<Hotel> getAllHotels(){
        return hotelService.findAllHotels();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation( value = "Get hotel by hotel ID")
    Hotel getHotelById(@PathVariable  Long id){
        return hotelService.findHotelById(id);
    }

    @RequestMapping(value = "addHotel", method = RequestMethod.POST)
    @ApiOperation( value = "Add a new hotel")
    Hotel addNewHotel(Hotel hotel){
        return hotelService.addHotel( hotel );
    }
}
