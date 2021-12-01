package com.ulasalle.lp3.evaluationfinal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class ProductListDTO {
    private Integer id;
    private String name;
    private String quantityPerUnit;
    private Double price;
    private Integer stock;
}
