package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.dto.ProductResponseDto;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
   @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;
    @Test
   public void testFetchProductById() {
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

