package Interviews_prep.DesignPattern.PracricExample.BuilderMethod;

public class Car {
    private String engine;
    private String chassis;
    private boolean interior;
    private String color;
    private boolean hasGPS;
    private boolean hasSunroof;
    private boolean hasParkingSensors;

    public Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.chassis = builder.chassis;
        this.interior = builder.interior;
        this.color = builder.color;
        this.hasGPS = builder.hasGPS;
        this.hasSunroof = builder.hasSunroof;
        this.hasParkingSensors = builder.hasParkingSensors;
    }

    public String getEngine() {
        return engine;
    }

    public String getChassis() {
        return chassis;
    }

    public boolean getInterior() {
        return interior;
    }

    public String getColor() {
        return color;
    }

    public boolean isHasGPS() {
        return hasGPS;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public boolean isHasParkingSensors() {
        return hasParkingSensors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", chassis='" + chassis + '\'' +
                ", interior='" + interior + '\'' +
                ", color='" + color + '\'' +
                ", hasGPS=" + hasGPS +
                ", hasSunroof=" + hasSunroof +
                ", hasParkingSensors=" + hasParkingSensors +
                '}';
    }




    public static class CarBuilder{
        private String engine;
        private String chassis;
        private Boolean interior;
        private String color;
        private boolean hasGPS;
        private boolean hasSunroof;
        private boolean hasParkingSensors;

        public CarBuilder(String engine, String chassis,boolean interior) {
            this.engine = engine;
            this.chassis = chassis;
            this.interior = interior;
        }


        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setHasGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public CarBuilder setHasSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public CarBuilder setHasParkingSensors(boolean hasParkingSensors) {
            this.hasParkingSensors = hasParkingSensors;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }
}
