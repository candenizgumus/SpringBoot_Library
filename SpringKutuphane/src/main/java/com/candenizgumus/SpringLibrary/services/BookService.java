package com.candenizgumus.SpringLibrary.services;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.repositories.BookRepository;
import com.candenizgumus.SpringLibrary.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class BookService extends ServiceManager<Book,Long>
{
    private final BookRepository repository;

    public BookService(BookRepository repository)
    {
        super(repository);
        this.repository = repository;
    }

    public Book save2(String title, String authorname, Integer pagenumber){
        return repository.save(Book.builder().title(title).authorname(authorname).pagenumber(pagenumber).build());
    }
}
