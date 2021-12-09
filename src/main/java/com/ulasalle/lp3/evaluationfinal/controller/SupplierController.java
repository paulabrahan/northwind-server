package com.ulasalle.lp3.evaluationfinal.controller;

import com.ulasalle.lp3.evaluationfinal.constant.ControllerConstant;
import com.ulasalle.lp3.evaluationfinal.model.WrapperResponse;
import com.ulasalle.lp3.evaluationfinal.model.dto.SupplierDTO;
import com.ulasalle.lp3.evaluationfinal.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
@Api(tags = "Supplier")
public class SupplierController {

    private final SupplierService service;


    @ApiOperation(value = "Process get supplier", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The supplier list was processed correctly.", response = SupplierDTO.class),
            @ApiResponse(code = 404, message = "Some supplier information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @GetMapping
    public ResponseEntity<WrapperResponse<List<SupplierDTO>>> findAll() {

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, service.findAll(), true)
                .createResponse(HttpStatus.OK);

    }
}
