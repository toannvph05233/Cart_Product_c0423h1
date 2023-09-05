package com.cart_product_c0423h1.repository;

import com.cart_product_c0423h1.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category, Integer> {
}
