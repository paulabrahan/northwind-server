package com.ulasalle.lp3.evaluationfinal.service;

import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductGroupDTO;
import org.springframework.data.domain.Pageable;


public interface SearchProductService {

    ProductGroupDTO findAllProduct(Pageable pageable);
    ProductDTO findById(Integer productId);

}
