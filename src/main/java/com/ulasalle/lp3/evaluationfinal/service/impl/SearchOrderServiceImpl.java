package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.model.dto.OrderDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.OrderGroupDTO;
import com.ulasalle.lp3.evaluationfinal.service.SearchOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchOrderServiceImpl implements SearchOrderService {

    @Override
    public OrderGroupDTO findAll(Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO findById(Integer productId) {
        return null;
    }
}
