package it.suntravelrest.service;

import it.suntravelrest.model.ContractRoom;
import it.suntravelrest.config.RoomRequirmentsPair;
import it.suntravelrest.model.RoomType;
import it.suntravelrest.config.SearchResult;
import it.suntravelrest.config.SearchResultLine;
import it.suntravelrest.repository.ContractRoomRepository;
import it.suntravelrest.service.base.ContractRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContractRoomServiceImpl implements ContractRoomService
{

    private final ContractRoomRepository contractRoomRepository;

    public ContractRoomServiceImpl( ContractRoomRepository contractRoomRepository )
    {
        this.contractRoomRepository = contractRoomRepository;
    }


    @Override public List<ContractRoom> getAllContracts()
    {
        return  contractRoomRepository.findAll();
    }

    @Override public List<SearchResult> searchContracts( List<RoomRequirmentsPair> roomRequirments, Date startDate, int nofNights )
    {
        return searchValidContarcts( roomRequirments,startDate, nofNights);
        //return null;
    }

    @Override public ContractRoom createContractRoom( ContractRoom contractRoom )
    {
        contractRoom.setCreatedAt( new Date(  ) );
        contractRoomRepository.save( contractRoom );
        return null;
    }

    private List<SearchResult> searchValidContarcts(List<RoomRequirmentsPair> roomRequirments, Date startDate, int nofNights  ){
        int numberOfTypes = roomRequirments.size();
        System.out.println("Total Req types " + numberOfTypes);
        int matchedNumOfTypes = 0;
        ContractRoom currentContractRoom;
        RoomType currentRoomType;
        List<ContractRoom> matchedRoomTypes =new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new java.sql.Date( startDate.getTime() ) );
        calendar.add(Calendar.DATE,nofNights);
        Date endDate =  new Date( calendar.getTimeInMillis() );
        List<SearchResult> searchResultList = new ArrayList<>(  );
        List<SearchResultLine> matchedRoomList = new ArrayList<>(  );
        List<ContractRoom> contractRoomsList = contractRoomRepository.findAll();

        for( int i=0; i<contractRoomsList.size();i++ ){
            currentContractRoom = contractRoomsList.get(i);

            if(currentContractRoom.getContractId().getStartDate().before( startDate ) && currentContractRoom.getContractId().getEndDate().after( endDate )){
                for(RoomRequirmentsPair roomRequirmentsPair : roomRequirments){
                    if(roomRequirmentsPair.getNumberOfAdults() <= currentContractRoom.getRoomType().getNoOfAdults() &&  roomRequirmentsPair.getNumberOfRooms() <=  currentContractRoom.getNoOfRooms()){
                        SearchResultLine searchResultLine = new SearchResultLine();
                        currentRoomType = currentContractRoom.getRoomType();
                        searchResultLine.setContractRoomTypeId( currentRoomType.getId() );
                        searchResultLine.setNoOfAdults( currentRoomType.getNoOfAdults() );
                        searchResultLine.setNoOfRooms( currentContractRoom.getNoOfRooms() );
                        searchResultLine.setPrice( currentContractRoom.getPrice() );
                        searchResultLine.setRoomTypeName( currentRoomType.getName() );
                        searchResultLine.setTotalLinePrice( calculateTotalLinePrice(currentContractRoom.getPrice(), nofNights, roomRequirmentsPair.getNumberOfAdults(), currentContractRoom.getContractId().getMarkup() ) );

                        matchedRoomList.add( searchResultLine );

                        SearchResult searchResult = new SearchResult();
                        searchResult.setContractId( currentContractRoom.getContractId().getId() );
                        searchResult.setContractName( currentContractRoom.getContractId().getName() );
                        searchResult.setHotelId( currentContractRoom.getContractId().getHotelId().getId() );
                        searchResult.setHotelName( currentContractRoom.getContractId().getHotelId().getName() );
                        searchResult.setMarkup( currentContractRoom.getContractId().getMarkup() );
                        searchResult.setResultLine( matchedRoomList );
                        searchResultList.add( searchResult );
                    }
                }

            }

        }
        return searchResultList;
    }

    private static double calculateTotalLinePrice(double roomPrice, int noOfNights, int noOfAdults, double markup){

        return (double)Math.round((((markup+100)/100) * roomPrice * noOfNights * noOfAdults)*100)/100;
    }


}
