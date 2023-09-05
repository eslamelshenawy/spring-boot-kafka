package br.com.example.davidarchanjo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Order implements Serializable {

    private String idorder;
    private String customer;
    private BigDecimal value;
}
