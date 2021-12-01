package com.ulasalle.lp3.evaluationfinal.service;

import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;

public interface UpdateProductService {
    ProductDTO updateStock(Integer productId,Integer stock);
    ProductDTO updatePrice(Integer productId,Double price);

}
