package com.candenizgumus.SpringLibrary.repositories;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{

    Optional<Customer> findByUsernameAndPassword(String username , String password);

}
