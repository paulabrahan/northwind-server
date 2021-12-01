package com.ulasalle.lp3.evaluationfinal.service.impl;

import com.ulasalle.lp3.evaluationfinal.dao.ProductDao;
import com.ulasalle.lp3.evaluationfinal.model.DeleteRQ;
import com.ulasalle.lp3.evaluationfinal.model.enitity.Product;
import com.ulasalle.lp3.evaluationfinal.service.DeleteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductServiceImpl implements DeleteProductService {

    private final ProductDao dao;
    @Override
    public DeleteRQ delete(Integer productId) {
        Product product = dao.findById(productId);
        dao.delete(product);
        return DeleteRQ.builder().response("Se elimino correctamente el producto").build();
    }
}
