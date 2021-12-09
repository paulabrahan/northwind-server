package com.ulasalle.lp3.evaluationfinal.converter;

import com.ulasalle.lp3.evaluationfinal.model.dto.CategoryDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter  implements Converter<Category, CategoryDTO>{

    @Override
    public CategoryDTO fromEntity(Category entity) {
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public Category fromDTO(CategoryDTO dto) {
        return null;
    }
}
