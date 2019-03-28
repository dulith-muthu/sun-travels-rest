package it.suntravelrest.service.base;

import it.suntravelrest.model.Contract;

import java.util.List;

public interface ContractService
{
    List<Contract> findAllContracts();

    Contract findContractById(Contract id);

    Contract createContract(Contract contract);
}
