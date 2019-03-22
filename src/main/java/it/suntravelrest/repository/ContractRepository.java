package it.suntravelrest.repository;

import it.suntravelrest.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long>
{
}
