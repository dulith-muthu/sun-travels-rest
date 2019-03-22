package it.suntravelrest.repository;
import it.suntravelrest.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long>
{

}
