package it.suntravelrest.service;

import it.suntravelrest.model.Contract;
import it.suntravelrest.repository.ContractRepository;
import it.suntravelrest.service.base.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService
{
    private final ContractRepository contractRepository;

    public ContractServiceImpl( ContractRepository contractRepository )
    {
        this.contractRepository = contractRepository;
    }

    @Override public List<Contract> findAllContracts()
    {
        return contractRepository.findAll();
    }

    @Override public Contract findContractById( Long id )
    {
        return contractRepository.findById( id ).get();
    }


}
