package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory;

class ToyotaFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new ToyotaCar();
    }

    @Override
    public Truck createTruck() {
        return new ToyotaTruck();
    }
}