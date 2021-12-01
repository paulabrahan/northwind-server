package com.ulasalle.lp3.evaluationfinal.converter;

import com.ulasalle.lp3.evaluationfinal.model.dto.ProductListDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductListConverter implements Converter<Product, ProductListDTO>{

    @Override
    public ProductListDTO fromEntity(Product entity) {
        return ProductListDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantityPerUnit(entity.getQuantityPerUnit())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .build();
    }

    @Override
    public Product fromDTO(ProductListDTO dto) {
        return null;
    }


}
