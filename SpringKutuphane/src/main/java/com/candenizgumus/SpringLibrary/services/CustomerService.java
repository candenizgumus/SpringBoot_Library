package com.candenizgumus.SpringLibrary.services;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.entities.Customer;
import com.candenizgumus.SpringLibrary.repositories.BookRepository;
import com.candenizgumus.SpringLibrary.repositories.CustomerRepository;
import com.candenizgumus.SpringLibrary.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ServiceManager<Customer,Long>
{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }


}
