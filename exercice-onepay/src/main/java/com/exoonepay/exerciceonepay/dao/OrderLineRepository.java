package com.exoonepay.exerciceonepay.dao;

import com.exoonepay.exerciceonepay.entities.OrderLine;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderLineRepository extends ReactiveCrudRepository<OrderLine, Integer> {
}
