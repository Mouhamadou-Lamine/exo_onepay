package com.exoonepay.exerciceonepay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class OrderLine {

    @Id
    private Integer id;
    private String productName;
    private int quantity;
    private BigDecimal price;

}
