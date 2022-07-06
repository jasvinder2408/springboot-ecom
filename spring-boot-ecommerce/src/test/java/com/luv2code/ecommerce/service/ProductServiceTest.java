package com.luv2code.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.dto.ProductResponseDto;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @Test
    void testFetchProductById() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Category Name");
        productCategory.setId(123L);
        productCategory.setProducts(new HashSet<>());

        Product product = new Product();
        product.setActive(true);
        product.setCategory(productCategory);
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setImageUrl("https://example.org/example");
        product.setName("Name");
        product.setSku("Sku");
        product.setUnitPrice(BigDecimal.valueOf(1L));
        product.setUnitsInStock(1);

        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((String) any())).thenReturn(ofResult);
        ProductResponseDto actualFetchProductByIdResult = productService.fetchProductById("42");
        assertEquals("42", actualFetchProductByIdResult.getId());
        assertEquals("Name", actualFetchProductByIdResult.getName());
        assertEquals("https://example.org/example", actualFetchProductByIdResult.getImageUrl());
        verify(productRepository).findById((String) any());
    }


}

