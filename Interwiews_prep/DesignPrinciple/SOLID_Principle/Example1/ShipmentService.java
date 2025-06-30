package Interwiews_prep.DesignPrinciple.SOLID_Principle.Example1;

import java.util.ArrayList;
import java.util.List;

public class ShipmentService {

    private final List<ShippingMethod>  shipments = new ArrayList<>();

    public void addShipping(ShippingMethod shipment) {
        shipments.add(shipment);
    }

    public void displayAllShipment() {

        for (ShippingMethod shipment : shipments) {
            System.out.println(shipment.getDetails());
        }
    }
    public double calculateTotalCost() {
        double totalCost = 0;
        for (ShippingMethod shipment : shipments) {
            totalCost += shipment.calculateCost();
        }
        return totalCost;
    }
}
