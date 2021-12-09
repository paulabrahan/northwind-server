package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.converter.SupplierConverter;
import com.ulasalle.lp3.evaluationfinal.model.dto.SupplierDTO;
import com.ulasalle.lp3.evaluationfinal.repository.SupplierRepository;
import com.ulasalle.lp3.evaluationfinal.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;
    private final SupplierConverter converter;

    @Override
    public List<SupplierDTO> findAll() {
        return converter.fromEntity(repository.findAll());
    }
}
