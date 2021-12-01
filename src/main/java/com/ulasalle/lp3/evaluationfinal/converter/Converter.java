package com.ulasalle.lp3.evaluationfinal.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<M, D> {

    D fromEntity(M entity);

    M fromDTO(D dto);

    default List<D> fromEntity(List<M> entityList) {
        return entityList.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    default List<M> fromDTO(List<D> dtoList) {
        return dtoList.stream()
                .map(this::fromDTO)
                .collect(Collectors.toList());
    }

}
