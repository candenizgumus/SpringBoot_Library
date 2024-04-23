package com.candenizgumus.SpringLibrary.services;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.entities.Customer;
import com.candenizgumus.SpringLibrary.entities.Rent;
import com.candenizgumus.SpringLibrary.entities.enums.Status;
import com.candenizgumus.SpringLibrary.repositories.BookRepository;
import com.candenizgumus.SpringLibrary.repositories.CustomerRepository;
import com.candenizgumus.SpringLibrary.repositories.RentRepository;
import com.candenizgumus.SpringLibrary.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentService extends ServiceManager<Rent, Long>
{
    private final RentRepository rentRepository;
    private final BookService bookService;
    private final CustomerService customerService;

    //TODO Metodların içindeki sout metinlerini exception olarak çevirip hata fırlatmak lazım
    //TODO Admin entitysi lazım

    @Override
    public Rent save(Rent rent)
    {
        if (!rentChecks(rent))
        {
            System.out.println("Kayıt islemi basarisiz.");
            return null;
        }
        rentProcesses(rent);
        return super.save(rent);
    }


    private boolean rentChecks(Rent rent)
    {
        Optional<Book> book = bookService.findById(rent.getBook().getId());
        Optional<Customer> customer = customerService.findById(rent.getCustomer().getId());

        if (book.isEmpty() || customer.isEmpty())
        {
            System.out.println("Musteri veya kitap bulunamadi");
            return false;
        }
        else if (book.get().getPrice() > customer.get().getBalance())
        {
            System.out.println("Yeterli bakiye yok");
            return false;
        } else if (book.get().getStatus() == Status.RENTED)
        {
            System.out.println("Kitap baskasi tarafindan kiralanmis");
            return false;
        }

        return true;
    }

    private void rentProcesses(Rent rent)
    {
        Optional<Book> book = bookService.findById(rent.getBook().getId());
        Optional<Customer> customer = customerService.findById(rent.getCustomer().getId());

        book.get().setStatus(Status.RENTED);
        customer.get().setBalance(customer.get().getBalance()-book.get().getPrice());
    }


    public RentService(RentRepository rentRepository, BookService bookService, CustomerService customerService)
    {
        super(rentRepository);
        this.rentRepository = rentRepository;
        this.bookService = bookService;

        this.customerService = customerService;
    }


}
