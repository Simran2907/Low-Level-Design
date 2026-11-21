package org.example.exceptions;

public class ProductOutOfStock extends RuntimeException{
    public ProductOutOfStock(){
        super("Product out of Stock");
    }
}
