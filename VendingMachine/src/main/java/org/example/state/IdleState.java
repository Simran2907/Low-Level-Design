package org.example.state;

import org.example.model.Inventory;
import org.example.service.InventoryService;
import org.example.service.VendingMachine;
import org.example.service.abstractions.VendingMachineState;

public class IdleState implements VendingMachineState {

    private final VendingMachine machine;

    public IdleState(VendingMachine vendingMachine){
        this.machine = vendingMachine;
    }

    @Override
    public void selectProduct(String productId) {
        InventoryService inventory = machine.getInventoryService();

        if (!inventory.isAvailable(productId)) {
            System.out.println("Product unavailable or out of stock");
            return;
        }

        Inventory item = inventory.getItem(productId);

        machine.setProduct(item.getProduct());
        machine.startTransaction();

        System.out.println(
                "Selected: " + item.getProduct().getName()
                        + ", Price: " + item.getProduct().getPrice()
        );

        machine.setCurrentState(new ProductSelectedState(machine));
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a product first");
    }

    @Override
    public void cancel() {
        System.out.println("No active transaction to cancel");
    }

    @Override
    public void dispense() {
        System.out.println("Select a product first");
    }
}
