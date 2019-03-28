package it.suntravelrest.service;

import it.suntravelrest.model.Contract;
import it.suntravelrest.repository.ContractRepository;
import it.suntravelrest.repository.ContractRepositoryImpl;
import it.suntravelrest.service.base.ContractService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService
{
    private final ContractRepositoryImpl contractRepository;

    public ContractServiceImpl( ContractRepositoryImpl contractRepository )
    {
        this.contractRepository = contractRepository;
    }

    @Override public List<Contract> findAllContracts()
    {
        return contractRepository.findAll();
    }

    @Override public Contract findContractById( Contract id )
    {
        return contractRepository.findById( id );
    }

    @Override public Contract createContract( Contract contract )
    {
        contract.setCreatedAt( new Date() );
        System.out.println("Hotel Id: " + contract.getHotelId().getId() );
        return contractRepository.save( contract );
    }


}
