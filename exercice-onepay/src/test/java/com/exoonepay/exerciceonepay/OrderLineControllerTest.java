package com.exoonepay.exerciceonepay;

import com.exoonepay.exerciceonepay.controller.OrderLineController;
import com.exoonepay.exerciceonepay.dao.OrderLineRepository;
import com.exoonepay.exerciceonepay.entities.OrderLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = OrderLineController.class)
public class OrderLineControllerTest {

    @MockBean
    OrderLineRepository orderLineRepository;

    @Autowired
    private WebTestClient webTestClient;

    BigDecimal bigDecimal = BigDecimal.valueOf(14.80);

    // Create new Order Test
    @Test
    void testCreateOrder(){
        OrderLine order = new OrderLine();
        order.setId(1);
        order.setProductName("gants");
        order.setQuantity(4);
        order.setPrice(bigDecimal);

        Mockito
                .when(orderLineRepository.save(order))
                .thenReturn(Mono.just(order));

        webTestClient.post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(order))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(orderLineRepository, Mockito.times(1)).save(order);
    }

    // Find Order By Id Test
    @Test
    void testGetOrderById(){
        OrderLine order = new OrderLine();
        order.setId(2);
        order.setProductName("bonnet");
        order.setQuantity(3);
        order.setPrice(bigDecimal);

        Mockito
                .when(orderLineRepository.findById(2))
                .thenReturn(Mono.just(order));

        webTestClient.get().uri("/{id}", 2)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.productName").isNotEmpty()
                .jsonPath("$.id").isEqualTo(2)
                .jsonPath("productName").isEqualTo("bonnet")
                .jsonPath("$.quantity").isEqualTo(3)
                .jsonPath("$.price").isEqualTo(bigDecimal);

        Mockito.verify(orderLineRepository, Mockito.times(1)).findById(2);

    }
}
