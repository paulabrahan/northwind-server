package com.ulasalle.lp3.evaluationfinal.model.enitity;

import com.ulasalle.lp3.evaluationfinal.model.dto.EmployeeDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "order_date")
    private Date creatAt;

    @Column(name = "required_date")
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;


}
