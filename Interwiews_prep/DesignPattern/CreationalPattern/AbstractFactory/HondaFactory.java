package Interwiews_prep.DesignPattern.CreationalPattern.AbstractFactory;

class HondaFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new HondaCar();
    }

    @Override
    public Truck createTruck() {
        return new HondaTruck();
    }
}
