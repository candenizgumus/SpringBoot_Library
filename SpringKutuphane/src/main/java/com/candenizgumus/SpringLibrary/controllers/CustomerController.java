package com.candenizgumus.SpringLibrary.controllers;



import com.candenizgumus.SpringLibrary.entities.Customer;
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
    public ResponseEntity<Boolean> login(String username, String password) {
        return customerService.login(username,password);
    }

    @GetMapping("/finduser")
    @CrossOrigin("*")
    public ResponseEntity<Customer> findByUsername(String username){
        return ResponseEntity.ok(customerService.findByUsername(username).get());
    }



}
