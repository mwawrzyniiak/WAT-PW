package pl.service;

import pl.entity.Car;

public class CarService {

    private static CarService instance = null;

    public static CarService getInstance() {
        if(instance == null) {
            instance = new CarService();
        }
        return instance;
    }

    private CarService() {}

    public void carGoing() {

    }

    public void carStop() {

    }

    public void addFuel(Car c1) {
        int value = c1.getFuel() + 1;
        c1.setFuel(value);
    }


}
