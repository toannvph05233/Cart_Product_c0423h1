package com.cart_product_c0423h1.service;

import com.cart_product_c0423h1.model.Product;
import com.cart_product_c0423h1.repository.ICategoryRepo;
import com.cart_product_c0423h1.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public List<Product> getAll(){
        return (List<Product>) iProductRepo.findAll();
    }

    public Product getByID(int id){
        return  iProductRepo.findById(id).get();
    }
}
