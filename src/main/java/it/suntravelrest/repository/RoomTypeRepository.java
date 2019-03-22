package it.suntravelrest.repository;

import it.suntravelrest.model.Hotel;
import it.suntravelrest.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoomTypeRepository extends Repository<RoomType, Long>
{
    List<RoomType> findAll();
    List<RoomType> findByAndHotelIdIs( Hotel id);
    List<RoomType> findByNoOfAdults(int numberOfAdults);
    RoomType save(RoomType roomType);
}
