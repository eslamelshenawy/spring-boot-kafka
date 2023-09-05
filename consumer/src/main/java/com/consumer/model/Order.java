package com.consumer.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Order implements Serializable {

    private String idorder;
    private String customer;
    private BigDecimal value;
}
