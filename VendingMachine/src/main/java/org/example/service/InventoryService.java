package org.example.service;

import org.example.model.Inventory;
import org.example.model.Product;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<String,Inventory> inventories = new HashMap<>();

    public Inventory getItem(String productId){
        return inventories.get(productId);
    }

    public boolean isAvailable(String productId){
        return inventories.get(productId).isAvailable();
    }

    public void addProduct(Product product,int quantity){
        inventories.computeIfAbsent(product.getId(),k -> new Inventory(product,0)).restock(quantity);
    }

    public void dispenseProduct(String productId){
        Inventory inventory = inventories.get(productId);
        if(inventory == null || !inventory.isAvailable()) throw new RuntimeException("Product Unavailable");
        inventory.reduceQuantity();
    }




}
