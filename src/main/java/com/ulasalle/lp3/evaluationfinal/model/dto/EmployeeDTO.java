package com.ulasalle.lp3.evaluationfinal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String region;
    private String country;

}
