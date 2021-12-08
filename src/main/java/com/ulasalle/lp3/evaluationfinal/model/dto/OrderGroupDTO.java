package com.ulasalle.lp3.evaluationfinal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderGroupDTO {

    private Long totalOrders;
    private List<OrderListDTO> orders;

}
