package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.converter.ProductConverter;
import com.ulasalle.lp3.evaluationfinal.converter.ProductListConverter;
import com.ulasalle.lp3.evaluationfinal.dao.ProductDao;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductGroupDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import com.ulasalle.lp3.evaluationfinal.service.SearchProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SearchProductServiceImpl implements SearchProductService {

    private final ProductDao dao;
    private final ProductListConverter listConverter;
    private final ProductConverter converter;

    @Override
    public ProductGroupDTO findAllProduct(Pageable pageable) {
        Page<Product> productPage = dao.findAll(pageable);

        return ProductGroupDTO.builder()
                .totalProducts(productPage.getTotalElements())
                .products(listConverter.fromEntity(productPage.getContent())).build();
    }

    @Override
    public ProductDTO findById(Integer productId) {
        return converter.fromEntity(dao.findById(productId)) ;
    }
}
