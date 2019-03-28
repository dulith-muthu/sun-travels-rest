package it.suntravelrest.repository;

import it.suntravelrest.model.Contract;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ContractRepository extends Repository<Contract, Long>
{
    Contract save(Contract contract);
    List<Contract> findAll();
    Contract findById(Contract contract);
}
