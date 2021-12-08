package com.ulasalle.lp3.evaluationfinal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Setter
@Getter
public class OrderDTO {

    private String id;
    private CustomerDTO customer;
    private EmployeeDTO employee;

    private Date creatAt;

    private Date requiredDate;
    private Date shippedDate;
    private Double total;
    private List<ItemDTO> items;
}
