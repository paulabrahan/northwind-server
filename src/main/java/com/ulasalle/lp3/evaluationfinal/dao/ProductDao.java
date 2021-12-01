package com.ulasalle.lp3.evaluationfinal.dao;

import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductDao {
    Page<Product> findAll(Pageable pageable);
    Product findById(Integer id);
    Product findTop();
    Product save(Product product);
    Boolean delete(Product product);
}
