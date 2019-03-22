package it.suntravelrest.controller;

import io.swagger.annotations.ApiOperation;
import it.suntravelrest.model.ContractRoom;
import it.suntravelrest.config.SearchCriteria;
import it.suntravelrest.config.SearchResult;
import it.suntravelrest.service.base.ContractRoomService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ContractRoomController.BASE_URL)
public class ContractRoomController
{
    public static final String BASE_URL = "/api/v1/contract_room";
    private final ContractRoomService contractRoomService;

    public ContractRoomController( ContractRoomService contractRoomService )
    {
        this.contractRoomService = contractRoomService;
    }

    @RequestMapping(value = "", method= RequestMethod.GET)
    @ApiOperation( value = "Get All Contracts")
    private List<ContractRoom> getAllContracts(){
        return contractRoomService.getAllContracts();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation( value = "Search with Criteria To Search Contracts")
    public List<SearchResult> searchContracts (@RequestBody SearchCriteria searchCriteria ){
        return contractRoomService.searchContracts( searchCriteria.getRoomRequirments(), searchCriteria.getStartDate() ,searchCriteria.getNumberOfNights() );
    }

}
