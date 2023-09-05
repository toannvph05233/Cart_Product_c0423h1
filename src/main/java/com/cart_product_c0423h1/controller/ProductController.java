package com.cart_product_c0423h1.controller;

import com.cart_product_c0423h1.model.Oder;
import com.cart_product_c0423h1.model.OderDetail;
import com.cart_product_c0423h1.model.Product;
import com.cart_product_c0423h1.repository.IOderDetailRepo;
import com.cart_product_c0423h1.repository.IOderRepo;
import com.cart_product_c0423h1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    IOderRepo iOderRepo;

    @Autowired
    IOderDetailRepo iOderDetailRepo;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id) {
        return productService.getByID(id);
    }

    @PostMapping("/oder")
    public ResponseEntity<?> createOder(@RequestBody Product[] products) {
        Oder oder = new Oder();
        oder.setDate(new Date(System.currentTimeMillis()));
        oder.setTotal(total(products));
        iOderRepo.save(oder);

        for (Product p : products) {
            OderDetail oderDetail = new OderDetail();
            oderDetail.setOder(oder);
            oderDetail.setProduct(p);
            oderDetail.setQuantity(p.getQuantity());
            iOderDetailRepo.save(oderDetail);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    public double total(Product[] products) {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice() * p.getQuantity();
        }
        return sum;
    }

}
