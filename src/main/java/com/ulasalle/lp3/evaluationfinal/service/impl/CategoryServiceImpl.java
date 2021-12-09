package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.converter.CategoryConverter;
import com.ulasalle.lp3.evaluationfinal.model.dto.CategoryDTO;
import com.ulasalle.lp3.evaluationfinal.repository.CategoryRepository;
import com.ulasalle.lp3.evaluationfinal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

     private final CategoryRepository repository;
     private final CategoryConverter converter;

    @Override
    public List<CategoryDTO> findAll() {
        return converter.fromEntity(repository.findAll());
    }
}
