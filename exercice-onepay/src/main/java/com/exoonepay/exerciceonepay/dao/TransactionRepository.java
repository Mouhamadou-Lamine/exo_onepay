package com.exoonepay.exerciceonepay.dao;

import com.exoonepay.exerciceonepay.entities.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Integer> {
}
