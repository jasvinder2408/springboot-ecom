package com.luv2code.ecommerce.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ProductResponseDto {

    private  String id;
    private String imageUrl;
    private String name;
}
