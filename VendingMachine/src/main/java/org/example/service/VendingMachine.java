package org.example.service;

import lombok.Data;
import org.example.model.Product;
import org.example.service.abstractions.PaymentStrategy;
import org.example.service.abstractions.VendingMachineState;
import org.example.state.IdleState;

import java.util.UUID;

@Data
public class VendingMachine {
    private final InventoryService inventoryService;
    private final DispensingService dispensingService;
    private final RefundService refundService;
    private final PaymentStrategy paymentStrategy;
    private Product product = null;
    private String transactionId = null;
    private VendingMachineState currentState = null;
    private double insertedAmount =0.0;
    private double leftAmount =0.0;

    public VendingMachine(InventoryService inventoryService,DispensingService dispensingService,RefundService refundService,PaymentStrategy paymentStrategy){
        this.inventoryService = inventoryService;
        this.dispensingService = dispensingService;
        this.refundService = refundService;
        this.paymentStrategy = paymentStrategy;
        this.currentState = new IdleState(this);
    }

    public void setInsertedAmount(double amount){
        this.insertedAmount+=amount;
    }
    public void selectProduct(String productId){
        this.currentState.selectProduct(productId);
    }

    public void insertMoney(double amount){
        this.currentState.insertMoney(amount);
        this.insertedAmount = amount;
    }

    public void cancel(){
        this.currentState.cancel();
    }

    public void dispense(){
        this.currentState.dispense();
    }

    public void startTransaction(){
        this.transactionId = UUID.randomUUID().toString();
    }
    public void resetTransaction(){
        this.product = null;
        this.transactionId = null;
        this.insertedAmount =0.0;
        this.currentState = new IdleState(this);
    }

}
