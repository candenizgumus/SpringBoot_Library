package com.candenizgumus.SpringLibrary.repositories;

import com.candenizgumus.SpringLibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>
{
}
