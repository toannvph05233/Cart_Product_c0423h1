package com.cart_product_c0423h1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Oder oder;
}
