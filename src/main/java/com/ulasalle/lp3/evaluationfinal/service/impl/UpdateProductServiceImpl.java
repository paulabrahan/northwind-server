package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.converter.ProductConverter;
import com.ulasalle.lp3.evaluationfinal.dao.ProductDao;
import com.ulasalle.lp3.evaluationfinal.exception.ValidateServiceException;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import com.ulasalle.lp3.evaluationfinal.service.UpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductServiceImpl implements UpdateProductService {

    private final ProductDao dao;
    private final ProductConverter converter;

    @Override
    public ProductDTO updateStock(Integer productId, Integer stock) {
        if(stock==null)
            throw new ValidateServiceException("Se debe de ingresar un numero entero para stock");

        Product product = dao.findById(productId);
        product.setStock(stock);
        return converter.fromEntity(dao.save(product));
    }

    @Override
    public ProductDTO updatePrice(Integer productId, Double price) {
        if(price==null)
            throw new ValidateServiceException("Se debe de ingresar un numero decimal para el nuevo precio");

        Product product = dao.findById(productId);
        product.setPrice(price);
        return converter.fromEntity(dao.save(product));
    }
}
