package com.ulasalle.lp3.evaluationfinal.converter;

import com.ulasalle.lp3.evaluationfinal.model.dto.CategoryDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductListDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.SupplierDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Category;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter  implements Converter<Product, ProductDTO>{

    @Override
    public ProductDTO fromEntity(Product entity) {
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantityPerUnit(entity.getQuantityPerUnit())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .category(CategoryDTO.builder()
                        .id(entity.getCategory().getId())
                        .name(entity.getCategory().getName())
                        .description(entity.getCategory().getDescription())
                        .build())
                .supplier(SupplierDTO.builder()
                        .id(entity.getSupplier().getId())
                        .name(entity.getSupplier().getName())
                        .build())
                .build();
    }

    @Override
    public Product fromDTO(ProductDTO dto) {

        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .quantityPerUnit(dto.getQuantityPerUnit())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .discontinued(0)
                .category(Category.builder()
                        .id(dto.getCategory().getId())
                        .build())
                .supplier(Supplier.builder()
                        .id(dto.getSupplier().getId())
                        .build())
                .build();

    }
}
