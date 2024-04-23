package com.candenizgumus.SpringLibrary.services;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.entities.Customer;
import com.candenizgumus.SpringLibrary.repositories.BookRepository;
import com.candenizgumus.SpringLibrary.repositories.CustomerRepository;
import com.candenizgumus.SpringLibrary.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long>
{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }



    public ResponseEntity<Boolean> login(String username, String password)
    {
        Optional<Customer> loggedCustomer = customerRepository.findByUsernameAndPassword(username,password);
        if (loggedCustomer.isPresent())
        {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }


    public Optional<Customer> findByUsername(String username)
    {
        return customerRepository.findByUsername(username);
    }
}
