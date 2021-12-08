package com.ulasalle.lp3.evaluationfinal.service;

import com.ulasalle.lp3.evaluationfinal.model.DeleteRQ;
import org.springframework.stereotype.Service;

public interface DeleteOrderService {
    DeleteRQ delete(Integer orderId);
}
