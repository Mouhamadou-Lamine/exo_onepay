package com.exoonepay.exerciceonepay;

import com.exoonepay.exerciceonepay.dao.TransactionRepository;
import com.exoonepay.exerciceonepay.entities.Transaction;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
public class ExerciceOnepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciceOnepayApplication.class, args);
	}

//	BigDecimal amountDec = BigDecimal.valueOf(123.30);
//
//	@Bean
//	ApplicationRunner init(TransactionRepository transactionRepository, DatabaseClient client) {
//		return args -> {
//			client.sql("create table IF NOT EXISTS TRANSACTION" +
//					"(id SERIAL PRIMARY KEY, amount DECIMAL(5,2) not null);"
//			).fetch().first().subscribe();
//			client.sql("DELETE FROM TRANSACTION;").fetch().first().subscribe();
//
//			Stream<Transaction> stream = Stream.of(
//					new Transaction(1, amountDec),
//					new Transaction(2, amountDec),
//					new Transaction(3, amountDec)
//			);
//
//			// initialize the database
//
//			transactionRepository.saveAll(Flux.fromStream(stream))
//					.then()
//					.subscribe(); // execute
//		};
//	}
}
