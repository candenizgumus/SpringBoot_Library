package com.candenizgumus.SpringLibrary.repositories;

import com.candenizgumus.SpringLibrary.entities.Customer;
import com.candenizgumus.SpringLibrary.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long>
{
}
