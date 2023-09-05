package com.cart_product_c0423h1.repository;

import com.cart_product_c0423h1.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepo extends PagingAndSortingRepository<Product, Integer> {
}
