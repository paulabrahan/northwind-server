package com.ulasalle.lp3.evaluationfinal.repository;

import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> , JpaSpecificationExecutor<Product> {

    Product findTopByOrderByIdDesc();
}
