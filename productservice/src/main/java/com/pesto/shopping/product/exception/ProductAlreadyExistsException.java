package com.pesto.shopping.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAlreadyExistsException extends RuntimeException{

    private String message;
}
