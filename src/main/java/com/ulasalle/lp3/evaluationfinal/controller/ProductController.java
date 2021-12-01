package com.ulasalle.lp3.evaluationfinal.controller;

import com.ulasalle.lp3.evaluationfinal.constant.ControllerConstant;
import com.ulasalle.lp3.evaluationfinal.exception.ValidateServiceException;
import com.ulasalle.lp3.evaluationfinal.model.DeleteRQ;
import com.ulasalle.lp3.evaluationfinal.model.WrapperResponse;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductDTO;
import com.ulasalle.lp3.evaluationfinal.model.dto.ProductGroupDTO;
import com.ulasalle.lp3.evaluationfinal.service.CreateProductService;
import com.ulasalle.lp3.evaluationfinal.service.DeleteProductService;
import com.ulasalle.lp3.evaluationfinal.service.SearchProductService;
import com.ulasalle.lp3.evaluationfinal.service.UpdateProductService;
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
@RequestMapping("/product")
@RequiredArgsConstructor
@Api(tags = "Product")
public class ProductController {

    private final SearchProductService searchProductService;
    private final CreateProductService createProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    @ApiOperation(value = "Process get product", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product list was processed correctly.", response = ProductGroupDTO.class),
            @ApiResponse(code = 404, message = "Some product information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @GetMapping
    public ResponseEntity<WrapperResponse<ProductGroupDTO>> findAll(@RequestParam(required = false, defaultValue = "0") int page,
                                                                    @RequestParam(required = false, defaultValue = "10") int rows,
                                                                    @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                    @RequestParam(required = false, defaultValue = "asc") String sort
    ) {
        Pageable pageable;

        if (Sort.Direction.DESC.name().equalsIgnoreCase(sort)) {
            pageable = PageRequest.of(page, rows, Sort.by(sortBy).descending());
        } else {
            pageable = PageRequest.of(page, rows, Sort.by(sortBy).ascending());
        }

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, searchProductService.findAllProduct(pageable), true)
                .createResponse(HttpStatus.OK);
    }

    @ApiOperation(value = "Process get product by id ", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product list was processed correctly.", response = ProductDTO.class),
            @ApiResponse(code = 404, message = "Some product information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @GetMapping("/{productId}")
    public ResponseEntity<WrapperResponse<ProductDTO>> findById(@PathVariable(value = "productId") Integer productId) {

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, searchProductService.findById(productId), true)
                .createResponse(HttpStatus.OK);
    }

    @ApiOperation(value = "Process create product", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product create was processed success.", response = ProductDTO.class),
            @ApiResponse(code = 404, message = "Some product information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred in creation product.")
    })

    @PostMapping()
    public ResponseEntity<WrapperResponse<ProductDTO>> create(@RequestBody ProductDTO dto) {
        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, createProductService.create(dto), true)
                .createResponse(HttpStatus.OK);
    }

    @ApiOperation(value = "Process update product stock", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product update was processed correctly.", response = ProductDTO.class),
            @ApiResponse(code = 404, message = "Some product information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred in update product.")
    })

    @PutMapping("/stock/{productId}")
    public ResponseEntity<WrapperResponse<ProductDTO>> updateStock(@PathVariable(value = "productId") Integer productId
                                                            , @RequestBody ProductDTO dto) {

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, updateProductService.updateStock(productId,dto.getStock()), true)
                .createResponse(HttpStatus.OK);
    }



    @ApiOperation(value = "Process update product price", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product update was processed correctly.", response = ProductDTO.class),
            @ApiResponse(code = 404, message = "Some product information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred in update product.")
    })

    @PutMapping("/price/{productId}")
    public ResponseEntity<WrapperResponse<ProductDTO>> updatePrice(@PathVariable(value = "productId") Integer productId
                                                                ,@RequestBody ProductDTO dto) {

        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE, updateProductService.updatePrice(productId,dto.getPrice()), true)
                .createResponse(HttpStatus.OK);
    }



    @ApiOperation(value = "Process delete product by id", response = WrapperResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product list was processed correctly.", response = DeleteRQ.class),
            @ApiResponse(code = 404, message = "Some order information isn't complete"),
            @ApiResponse(code = 500, message = "An error occurred while processing the information.")
    })
    @DeleteMapping("/{productId}")
    public ResponseEntity<WrapperResponse<DeleteRQ>> delete(@PathVariable(value = "productId") Integer productId) {
        ;
        return new WrapperResponse<>(ControllerConstant.SUCCESS_MESSAGE,deleteProductService.delete(productId) , true)
                .createResponse(HttpStatus.OK);
    }


}
