package it.suntravelrest.repository;

import it.suntravelrest.model.Contract;
import it.suntravelrest.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class ContractRepositoryImpl implements ContractRepository
{
    @PersistenceContext
    private final EntityManager entityManager;


    public ContractRepositoryImpl( EntityManager entityManager )
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Contract save( Contract contract )
    {
        Hotel hotel = entityManager.getReference( Hotel.class, contract.getHotelId().getId() );
        contract.setHotelId( hotel );
        entityManager.persist( contract );

//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist( contract );


        return contract;
    }

    @Override public List<Contract> findAll()
    {
        return null;
    }

    @Override public Contract findById( Contract contract )
    {
        return null;
    }
}
