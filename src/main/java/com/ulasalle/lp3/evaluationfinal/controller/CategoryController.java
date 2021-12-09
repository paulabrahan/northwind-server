package com.ulasalle.lp3.evaluationfinal.controller;

import com.ulasalle.lp3.evaluationfinal.constant.ControllerConstant;
import com.ulasalle.lp3.evaluationfinal.model.WrapperResponse;
import com.ulasalle.lp3.evaluationfinal.model.dto.CategoryDTO;
import com.ulasalle.lp3.evaluationfinal.service.CategoryService;
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
@RequestMapping("/category")
@RequiredArgsConstructor
@Api(tags = "Category")
public class CategoryController {

    private final CategoryService service;

    @ApiOperation(value = "Process get category", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category list was processed correctly.", response = CategoryDTO.class),
            @ApiResponse(code = 404, message = "Some category information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @GetMapping
    public ResponseEntity<WrapperResponse<List<CategoryDTO>>> findAll() {

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, service.findAll(), true)
                .createResponse(HttpStatus.OK);

    }
}
