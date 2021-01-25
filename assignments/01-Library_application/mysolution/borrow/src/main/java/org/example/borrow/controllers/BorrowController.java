package org.example.borrow.controllers;

import org.example.borrow.models.Borrow;
import org.example.borrow.repos.BorrowRepository;
import org.example.borrow.services.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping(value = "/v2/borrowings")
public class BorrowController {

    @Autowired
    Notification notification;

    @Value("${kafka.sms.message}")
    private String message;

    @Autowired
    private final BorrowingRepository borrowingRepository;

    public BorrowController(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    //set borrow
    @RequestMapping(method = RequestMethod.PUT)
    public Borrow setBorrow(@RequestBody Borrow borrow){
        notification.sendSMS(borrow);
        System.out.println(borrow);
        log.info("set");
        return borrowRepository.save(borrow);

    }

    //get borrow
    @RequestMapping(value = "/{borrowId}", method = RequestMethod.GET)
    public Borrow getBorrow(@PathVariable long borrowId){
        Optional<Borrow> borrowOpt = borrowRepository.findById(borrowId);
        if(borrowOpt.isPresent()){
            log.info("Get");
            return borrowOpt.get();
        }else{
            log.warn("Not found");
            return null;
        }
    }

    //edit borrow
    @RequestMapping(value = "/{borrowId}", method = RequestMethod.POST)
    public Borrow editBorrow(@RequestBody Borrow borrow, @PathVariable long borrowId){
        log.info("Edit ");
        return borrowRepository.save(borrow);
    }
}