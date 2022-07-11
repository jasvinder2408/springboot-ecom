package com.luv2code.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductAddressDto {

    private String name;
    private String price;

    private String street;
    private String city;

}
