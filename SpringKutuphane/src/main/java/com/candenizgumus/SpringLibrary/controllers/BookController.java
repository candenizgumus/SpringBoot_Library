package com.candenizgumus.SpringLibrary.controllers;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController
{
    private final BookService kitapService;

    @PostMapping("/save1")
    public ResponseEntity<Book> save(@RequestBody Book kitap){
        return ResponseEntity.ok(kitapService.save(kitap));
    }

    @PostMapping("/save2")
    public ResponseEntity<Book> save2(String title, String authorname, @RequestParam(defaultValue = "0") @Nullable Integer pagenumber){
        return ResponseEntity.ok(kitapService.save2(title, authorname, pagenumber));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(kitapService.findAll());
    }


}
