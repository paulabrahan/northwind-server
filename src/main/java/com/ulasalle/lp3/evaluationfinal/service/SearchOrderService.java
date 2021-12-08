package com.ulasalle.lp3.evaluationfinal.service;

import com.ulasalle.lp3.evaluationfinal.model.dto.OrderDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.OrderGroupDTO;
import org.springframework.data.domain.Pageable;

public interface SearchOrderService {
    OrderGroupDTO findAll(Pageable pageable);

    OrderDTO findById(Integer productId);
}
