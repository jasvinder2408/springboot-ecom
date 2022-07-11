package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.ProductResponseDto;

import com.luv2code.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> fetchAllProduct(){

        return ResponseEntity.ok(productService.fetchAllProduct());

    }
  //Add a mapping for Get/product/{productId
  @GetMapping("/all/{productId}")
  public ResponseEntity<ProductResponseDto>  fetchProductById(@PathVariable("productId") String id){

      return ResponseEntity.ok(productService.fetchProductById(id));

  }
    }


