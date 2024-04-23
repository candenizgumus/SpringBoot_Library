package com.candenizgumus.SpringLibrary.controllers;

import com.candenizgumus.SpringLibrary.entities.Customer;

import com.candenizgumus.SpringLibrary.entities.Rent;
import com.candenizgumus.SpringLibrary.entities.enums.Status;
import com.candenizgumus.SpringLibrary.services.BookService;
import com.candenizgumus.SpringLibrary.services.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController
{
    private final RentService rentService;


    @PostMapping("/save")
    public ResponseEntity<Rent> save(@RequestBody Rent rent){

        return ResponseEntity.ok(rentService.save(rent));
    }



    @GetMapping("/findall")
    public ResponseEntity<List<Rent>> findAll(){
        return ResponseEntity.ok(rentService.findAll());
    }


}
