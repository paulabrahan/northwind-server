package com.ulasalle.lp3.evaluationfinal.service;

import com.ulasalle.lp3.evaluationfinal.model.dto.OrderDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;

public interface CreateOrderService {

    OrderDTO create(OrderDTO dto);
}
