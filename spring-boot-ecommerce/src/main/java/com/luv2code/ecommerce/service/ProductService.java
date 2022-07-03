package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.dto.ProductResponseDto;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

       public List<Product> fetchAllProduct1(){
           List<Product> productList=productRepository.findAll();

           return productList;
       }

    public List<ProductResponseDto> fetchAllProduct(){
        List<Product> products= productRepository.findAll();
        // List<Demo_Product> demo_products= products.stream().map(product -> new Demo_Product(product.getId(), product.getImageUrl(), product.getName())).collect(Collectors.toList());
        ProductResponseDto demo_products=null;
        ArrayList<ProductResponseDto> products1= new ArrayList<>();
        for (Product product: products){
            demo_products= new ProductResponseDto(product.getId(), product.getImageUrl(), product.getName());
            products1.add(demo_products);
        }
        return products1;
    }

    public  ProductResponseDto fetchProductById(Long id){
          Product product= productRepository.findById(id).get();
          ProductResponseDto demo_products1=null;
          if (product!= null){
              demo_products1= new ProductResponseDto(product.getId(), product.getImageUrl(), product.getName());
          }
           return demo_products1 ;
    }

}
