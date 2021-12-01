package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.converter.ProductConverter;
import com.ulasalle.lp3.evaluationfinal.dao.ProductDao;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import com.ulasalle.lp3.evaluationfinal.service.CreateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductServiceImpl implements CreateProductService {

    private final ProductDao dao;
    private final ProductConverter converter;


    @Override
    public ProductDTO create(ProductDTO productDTO) {
        productDTO.setId(dao.findTop().getId()+1);
        Product product = dao.save(converter.fromDTO(productDTO));
        return converter.fromEntity(product);
    }
}
