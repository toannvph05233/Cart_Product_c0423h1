package com.cart_product_c0423h1.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private String name;
    private double price;
    private String img;
    private String status;
    @ManyToOne
    private Category category;
}
