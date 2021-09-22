package com.exoonepay.exerciceonepay.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Transaction {

    @Id
    private Integer id;
    private BigDecimal amount;
    private List<OrderLine> orderLines;

    @Getter
    @RequiredArgsConstructor
    public enum PaymentType {
        CREDIT_CARD,
        GIFT_CARD,
        PAYPAL
    }

    @Getter
    @RequiredArgsConstructor
    public  enum Status {
        NEW,
        AUTHORIZED,
        CAPTURED
    }
}
