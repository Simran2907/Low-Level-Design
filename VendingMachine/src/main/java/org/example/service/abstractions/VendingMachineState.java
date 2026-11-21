package org.example.service.abstractions;

public interface VendingMachineState {

    void selectProduct(String productId);
    void insertMoney(double amount);
    void cancel();
    void dispense();
}
