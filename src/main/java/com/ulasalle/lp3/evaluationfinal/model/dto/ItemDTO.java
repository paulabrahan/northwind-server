package com.ulasalle.lp3.evaluationfinal.model.dto;

import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ItemDTO {

    private Integer id;
    private Integer orderId;
    private Product product;
    private Integer quantity;
    private Double discount;
    private Double price;

}
