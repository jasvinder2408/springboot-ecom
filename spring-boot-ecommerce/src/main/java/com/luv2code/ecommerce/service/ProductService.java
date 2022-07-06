package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.dto.ProductAddressDto;
import com.luv2code.ecommerce.dto.ProductResponseDto;
import com.luv2code.ecommerce.entity.Address;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        ProductResponseDto demo_products=null;
        ArrayList<ProductResponseDto> products1= new ArrayList<>();
        for (Product product: products){
            demo_products= new ProductResponseDto(product.getId(), product.getImageUrl(), product.getName());
            products1.add(demo_products);
        }
        return products1;
    }

    public  ProductResponseDto fetchProductById(String id){
          Optional<Product> product= productRepository.findById(id);
          ProductResponseDto demo_products1=null;
              demo_products1= new ProductResponseDto(product.get().getId(), product.get().getImageUrl(), product.get().getName());
           return demo_products1 ;
    }

}
