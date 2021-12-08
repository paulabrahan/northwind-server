package com.ulasalle.lp3.evaluationfinal.controller;

import com.ulasalle.lp3.evaluationfinal.constant.ControllerConstant;
import com.ulasalle.lp3.evaluationfinal.model.DeleteRQ;
import com.ulasalle.lp3.evaluationfinal.model.WrapperResponse;
import com.ulasalle.lp3.evaluationfinal.model.dto.OrderDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.OrderGroupDTO;

import com.ulasalle.lp3.evaluationfinal.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Api(tags = "Order")
public class OrderController {

    private final SearchOrderService searchOrderService;
    private final CreateOrderService createOrderService;
    private final DeleteOrderService deleteOrderService;

    @ApiOperation(value = "Process get order", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order list was processed correctly.", response = OrderGroupDTO.class),
            @ApiResponse(code = 404, message = "Some order information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @GetMapping
    public ResponseEntity<WrapperResponse<OrderGroupDTO>> findAll(@RequestParam(required = false, defaultValue = "0") int page,
                                                                  @RequestParam(required = false, defaultValue = "10") int rows,
                                                                  @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                  @RequestParam(required = false, defaultValue = "asc") String sort)
    {
        Pageable pageable;

        if (Sort.Direction.DESC.name().equalsIgnoreCase(sort)) {
            pageable = PageRequest.of(page, rows, Sort.by(sortBy).descending());
        } else {
            pageable = PageRequest.of(page, rows, Sort.by(sortBy).ascending());
        }

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, searchOrderService.findAll(pageable), true)
                .createResponse(HttpStatus.OK);
    }

    @ApiOperation(value = "Process get order by id ", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order list was processed correctly.", response = OrderDTO.class),
            @ApiResponse(code = 404, message = "Some order information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @GetMapping("/{orderId}")
    public ResponseEntity<WrapperResponse<OrderDTO>> findById(@PathVariable(value = "orderId") Integer orderId) {

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, searchOrderService.findById(orderId), true)
                .createResponse(HttpStatus.OK);
    }

    @ApiOperation(value = "Process create order", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order create was processed success.", response = OrderDTO.class),
            @ApiResponse(code = 404, message = "Some order information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred in creation order.")
    })

    @PostMapping()
    public ResponseEntity<WrapperResponse<OrderDTO>> create(@RequestBody OrderDTO dto) {
        return new WrapperResponse<OrderDTO>(ControllerConstant.SUCCESS_MESSAGE, createOrderService.create(dto), true)
                .createResponse(HttpStatus.OK);
    }


    @ApiOperation(value = "Process delete order by id", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order list was processed correctly.", response = DeleteRQ.class),
            @ApiResponse(code = 404, message = "Some order information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @DeleteMapping("/{orderId}")
    public ResponseEntity<WrapperResponse<DeleteRQ>> delete(@PathVariable(value = "orderId") Integer orderId) {
        
        return new WrapperResponse<DeleteRQ>(ControllerConstant.SUCCESS_MESSAGE,deleteOrderService.delete(orderId) , true)
                .createResponse(HttpStatus.OK);
    }




}
