package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.Demo_Product;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
     @GetMapping("/all")
     public ResponseEntity<List<Demo_Product>> fetchAllProduct(){
       List<Product> products= productService.fetchAllProduct();
     // List<Demo_Product> demo_products= products.stream().map(product -> new Demo_Product(product.getId(), product.getImageUrl(), product.getName())).collect(Collectors.toList());
         Demo_Product demo_products=null;
         ArrayList<Demo_Product> products1= new ArrayList<>();
         for (Product product: products){
            demo_products= new Demo_Product(product.getId(), product.getImageUrl(), product.getName());
                     products1.add(demo_products);
         }

         return ResponseEntity.ok(products1);

        }

}
