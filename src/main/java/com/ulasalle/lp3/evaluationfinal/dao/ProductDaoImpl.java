package com.ulasalle.lp3.evaluationfinal.dao;

import com.ulasalle.lp3.evaluationfinal.exception.NoDataFoundException;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import com.ulasalle.lp3.evaluationfinal.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao{
    private final ProductRepository repository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return  repository.findAll((Specification<Product>)(root, query, criteriaBuilder) -> {Predicate predicate = criteriaBuilder.conjunction();return predicate; },pageable);
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> optional = repository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoDataFoundException("No existe un producto con el id ingresado");
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Boolean delete(Product product) {
        repository.delete(product);
        return true;
    }

    @Override
    public Product findTop() {
        return repository.findTopByOrderByIdDesc();
    }
}
