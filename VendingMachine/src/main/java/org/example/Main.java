package org.example;

import org.example.model.Product;
import org.example.service.DispensingService;
import org.example.service.InventoryService;
import org.example.service.RefundService;
import org.example.service.VendingMachine;
import org.example.strategy.CashPaymentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() {
        InventoryService inventoryService = new InventoryService();
        inventoryService.addProduct(new Product("P1", "Chocolate", 30.00), 5);
        inventoryService.addProduct(new Product("P2", "Chips",20.00), 3);
        inventoryService.addProduct(new Product("P3", "Water", 15.00), 2);

        DispensingService dispensingService = new DispensingService();
        RefundService refundService = new RefundService();

        VendingMachine machine = new VendingMachine(inventoryService, dispensingService, refundService,
                new CashPaymentStrategy());
        machine.selectProduct("P1");
        machine.insertMoney(45);
        machine.dispense();
        System.out.println(inventoryService.getItem(machine.getProduct().getId()).getQuantity());
    }
}
