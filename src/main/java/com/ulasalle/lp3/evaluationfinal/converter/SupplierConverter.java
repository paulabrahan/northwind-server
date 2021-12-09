package com.ulasalle.lp3.evaluationfinal.converter;

import com.ulasalle.lp3.evaluationfinal.model.dto.SupplierDTO;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter implements Converter<Supplier, SupplierDTO>{
    @Override
    public SupplierDTO fromEntity(Supplier entity) {
        return SupplierDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Supplier fromDTO(SupplierDTO dto) {
        return null;
    }
}
