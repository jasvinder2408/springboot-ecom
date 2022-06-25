package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> fetchAllProduct(){
        List<Product> productList=productRepository.findAll();
        for(Product product: productList){

        }
        return productList;
    }

}
