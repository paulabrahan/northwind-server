package com.ulasalle.lp3.evaluationfinal.model.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "order_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Product order_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "unit_price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "quantity")
    private Integer quantity;


}
