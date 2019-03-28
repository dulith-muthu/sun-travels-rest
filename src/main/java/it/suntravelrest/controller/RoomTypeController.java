package it.suntravelrest.controller;

import io.swagger.annotations.ApiOperation;
import it.suntravelrest.model.Hotel;
import it.suntravelrest.model.RoomType;
import it.suntravelrest.service.base.RoomTypeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RoomTypeController.BASE_URL)
public class RoomTypeController
{
    public static final String BASE_URL = "/api/v1/roomtype";
    private final RoomTypeService roomTypeService;

    public RoomTypeController( RoomTypeService roomTypeService )
    {
        this.roomTypeService = roomTypeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation( value = "Get all Room Types")
    List<RoomType> getAllHotels(){
        return roomTypeService.getAllRoomTypes();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation( value = "Add a new room type")
    RoomType addNewHotel(RoomType roomType){
        return roomTypeService.addNewRoomType( roomType );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation( value = "Get Room Types by hotel ID")
    List<RoomType> getHotelById(@PathVariable Hotel id){
        return roomTypeService.getAllRoomTypesByHotelId(id);
    }

    @RequestMapping(value = "/getByNumberAdults/{numberOfAdults}", method = RequestMethod.GET)
    @ApiOperation( value = "Get Room Types by number of Adults")
    List<RoomType> getbyNumberOfAdults(@PathVariable int numberOfAdults){
        return roomTypeService.getAllByNumberOfAdults(numberOfAdults);
    }


}
