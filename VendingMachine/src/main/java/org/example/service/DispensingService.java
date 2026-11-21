package org.example.service;

import org.example.model.Product;

public class DispensingService {

    public void dispense(Product product){
        System.out.println("Dispensing Product"+product.getName());
    }
}
