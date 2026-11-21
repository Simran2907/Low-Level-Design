package org.example.state;

import org.example.service.VendingMachine;
import org.example.service.abstractions.VendingMachineState;

public class ProductSelectedState implements VendingMachineState {

    private final VendingMachine machine;

    public ProductSelectedState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productId) {
        System.out.println("Product already selected. Please insert money");
    }

    @Override
    public void insertMoney(double amount) {
        if(amount <= 0){
            throw new RuntimeException("Invalid amount of money");
        }

        machine.getPaymentStrategy().acceptPayment(amount);
        machine.setInsertedAmount(amount);
        double remainingAmount = machine.getProduct().getPrice() - machine.getInsertedAmount();
        if(remainingAmount > 0){
            System.out.println("Please insert "+remainingAmount+" more");
            machine.setLeftAmount(remainingAmount);
            machine.setCurrentState(new PaymentPendingState(machine));
            return;
        }
        machine.setCurrentState(new DispensingState(machine));
    }

    @Override
    public void cancel() {
        machine.resetTransaction();
        System.out.println("Cancelled Successfully");
    }

    @Override
    public void dispense() {
        System.out.println("Please pay first");
    }
}
