package com.exoonepay.exerciceonepay.controller;

import com.exoonepay.exerciceonepay.dao.OrderLineRepository;
import com.exoonepay.exerciceonepay.entities.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class OrderLineController {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<OrderLine>> getById(@PathVariable("id") Integer id){
        Mono<OrderLine> order = orderLineRepository.findById(id);
        HttpStatus status = (order != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(order, status);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderLine> getAll(){
        return orderLineRepository.findAll();
    }

    @PostMapping(value = {"/create", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrderLine order){
        orderLineRepository.save(order);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderLine> update(@RequestBody OrderLine order){
        return orderLineRepository.save(order);
    }

}
