package org.example.state;

import org.example.service.VendingMachine;
import org.example.service.abstractions.VendingMachineState;

public class PaymentPendingState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public PaymentPendingState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(String productId) {
        System.out.println("Cancel this transaction or pay completely to start next transaction!");
    }

    @Override
    public void insertMoney(double amount) {
        if(amount <= 0) throw  new RuntimeException("Invalid amount");
        vendingMachine.setInsertedAmount(amount);
        double remainingAmount = vendingMachine.getLeftAmount() -vendingMachine.getInsertedAmount();
        if(remainingAmount > 0){
            System.out.println("Please insert "+remainingAmount+" more");
            vendingMachine.setLeftAmount(remainingAmount);
            vendingMachine.setCurrentState(new PaymentPendingState(vendingMachine));
            return;
        }
        vendingMachine.setCurrentState(new DispensingState(vendingMachine));
    }

    @Override
    public void cancel() {
        vendingMachine.getRefundService().refund(vendingMachine.getInsertedAmount(), vendingMachine.getPaymentStrategy());
        vendingMachine.resetTransaction();
        System.out.println("Transaction Cancelled");
    }

    @Override
    public void dispense() {
        System.out.println("Payment is not complete");
    }
}
