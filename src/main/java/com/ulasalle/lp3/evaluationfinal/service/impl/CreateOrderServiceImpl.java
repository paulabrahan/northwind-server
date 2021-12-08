package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.model.dto.OrderDTO;
import com.ulasalle.lp3.evaluationfinal.service.CreateOrderService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateOrderServiceImpl implements CreateOrderService {


    @Override
    public OrderDTO create(OrderDTO dto) {
        return null;
    }
}
