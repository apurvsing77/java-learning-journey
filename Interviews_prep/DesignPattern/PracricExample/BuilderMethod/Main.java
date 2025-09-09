package Interviews_prep.DesignPattern.PracricExample.BuilderMethod;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("BS-7","RJ14-C2025",true).
                setColor("Black").
                setHasGPS(true).
                setHasSunroof(true).
                setHasParkingSensors(true).
                build();
        Car car1 = new Car.CarBuilder("BS-9","RJ14-C2022",true).build();


                System.out.println(car1);
    }

}
