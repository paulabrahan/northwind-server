package com.ulasalle.lp3.evaluationfinal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class OrderListDTO {
    private Integer id;
    private Date creatAt;
    private Date requiredDate;
    private Date shippedDate;
    private String customer;
    private String employee;
    private Double total;
}
