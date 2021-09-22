package com.exoonepay.exerciceonepay.controller;

import com.exoonepay.exerciceonepay.dao.TransactionRepository;
import com.exoonepay.exerciceonepay.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Flux<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    @PostMapping(value = {"/create", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Transaction transaction){
        transactionRepository.save(transaction);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Transaction> update(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
