package com.candenizgumus.SpringLibrary.controllers;

import com.candenizgumus.SpringLibrary.entities.Book;
import com.candenizgumus.SpringLibrary.entities.Customer;
import com.candenizgumus.SpringLibrary.services.BookService;
import com.candenizgumus.SpringLibrary.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController
{
    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.save(customer));
    }



    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
        return customerService.login(username, password);
    }



}
