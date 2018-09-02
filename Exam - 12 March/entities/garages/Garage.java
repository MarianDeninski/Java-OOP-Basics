package nfs.entities.garages;

import nfs.entities.cars.Car;

import java.util.*;

public class Garage {

    private Collection<Car>parkedCars;

    public Garage(){

        this.parkedCars = new LinkedList<>();
    }

    public List<Car> getParkedCars() {
        return (List<Car>) parkedCars;
    }

    public void setParkedCars(Car car) {
        this.parkedCars.add(car);
    }
}
