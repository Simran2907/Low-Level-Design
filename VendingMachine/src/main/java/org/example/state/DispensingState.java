package org.example.state;

import org.example.exceptions.ProductOutOfStock;
import org.example.model.Product;
import org.example.service.VendingMachine;
import org.example.service.abstractions.VendingMachineState;

public class DispensingState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productId) {
        System.out.println("Please wait, dispensing in progress");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Payment is already completed");
    }

    @Override
    public void cancel() {
        System.out.println("Cannot cancel during dispensing");
    }

    @Override
    public void dispense() {
        try {
            Product product = vendingMachine.getProduct();
            if (!vendingMachine.getInventoryService().isAvailable(product.getId())) {
                throw new ProductOutOfStock();
            }
            vendingMachine.getDispensingService().dispense(product);
            vendingMachine.getInventoryService().dispenseProduct(product.getId());
            double remainingPrice = vendingMachine.getInsertedAmount() - product.getPrice();
            if (remainingPrice > 0) {
                vendingMachine.getPaymentStrategy().returnChange(remainingPrice);
                vendingMachine.resetTransaction();
            }
        }catch (Exception e){
            System.out.println("Dispensing failed: " + e.getMessage());
            vendingMachine.getRefundService().refund(vendingMachine.getInsertedAmount(), vendingMachine.getPaymentStrategy());
            vendingMachine.resetTransaction();
        }
    }
}
