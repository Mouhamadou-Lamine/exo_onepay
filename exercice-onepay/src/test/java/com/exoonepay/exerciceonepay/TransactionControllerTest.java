package com.exoonepay.exerciceonepay;

import com.exoonepay.exerciceonepay.controller.TransactionController;
import com.exoonepay.exerciceonepay.dao.TransactionRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = TransactionController.class)
public class TransactionControllerTest {

    @MockBean
    TransactionRepository transactionRepository;

    @Autowired
    private WebTestClient webTestClient;


}
