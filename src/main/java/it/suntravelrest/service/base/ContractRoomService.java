package it.suntravelrest.service.base;

import it.suntravelrest.model.ContractRoom;
import it.suntravelrest.config.RoomRequirmentsPair;
import it.suntravelrest.config.SearchResult;

import java.util.Date;
import java.util.List;

public interface ContractRoomService
{
    List<ContractRoom> getAllContracts();

    List<SearchResult> searchContracts( List<RoomRequirmentsPair> roomRequirments, Date startDate, int nofNights);
}
