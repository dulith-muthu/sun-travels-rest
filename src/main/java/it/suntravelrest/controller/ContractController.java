package it.suntravelrest.controller;

import io.swagger.annotations.ApiOperation;
import it.suntravelrest.model.Contract;
import it.suntravelrest.service.base.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ContractController.BASE_URL)
public class ContractController
{
    public static final String BASE_URL = "/api/v1/contract";
    public final ContractService contractService;

    public ContractController( ContractService contractService )
    {
        this.contractService = contractService;
    }

    @RequestMapping(value = "/health", method= RequestMethod.GET)
    @ApiOperation( value = "HeartBeat End point for health Checks")
    public HttpStatus heartBeatEndpoint(){
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(value = "", method= RequestMethod.GET)
    @ApiOperation( value = "Get all contracts")
    public List<Contract> findAllContracts(){
        return contractService.findAllContracts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation( value = "Get contracts by contract ID")
    public Contract findContractById( @PathVariable Long id ){
        return contractService.findContractById( id );
    }
}
