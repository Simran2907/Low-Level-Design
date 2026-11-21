package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.exceptions.ProductOutOfStock;

@AllArgsConstructor
@Builder
@Data
public class Inventory {
    private Product product;
    private int quantity;

    public boolean isAvailable(){
        return this.quantity > 0;
    }

    public void reduceQuantity(){
        if(this.quantity < 0) throw new ProductOutOfStock();
        this.quantity--;
    }

    public void restock(int quantity){
        this.quantity += quantity;
    }
}
