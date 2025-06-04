package Interwiews_prep.DesignPattern.CreationalPattern.AbstractFactory;

public class VehicleClient {
    public static void main(String[] args) {
        String manufacturer = "honda"; // Simulate getting manufacturer from config

        VehicleFactory factory;

        if (manufacturer.equalsIgnoreCase("toyota")) {
            factory = new ToyotaFactory();
        } else if (manufacturer.equalsIgnoreCase("honda")) {
            factory = new HondaFactory();
        } else {
            throw new IllegalArgumentException("Unsupported manufacturer: " + manufacturer);
        }

        Car car = factory.createCar();
        Truck truck = factory.createTruck();

        System.out.println("Creating vehicles from: " + manufacturer);
        System.out.println("Car: " + car.getModel());
        System.out.println("Truck: " + truck.getModel());
    }
}
