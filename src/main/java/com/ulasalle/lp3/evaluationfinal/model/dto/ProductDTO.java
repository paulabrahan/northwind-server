package com.ulasalle.lp3.evaluationfinal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {

    private Integer id;
    private String name;
    private String quantityPerUnit;
    private Double price;
    private Integer stock;
    private CategoryDTO category;
    private SupplierDTO supplier;


}
