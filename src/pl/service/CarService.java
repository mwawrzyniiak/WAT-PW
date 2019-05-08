package pl.service;

import pl.entity.Car;

import java.util.concurrent.TimeUnit;

public class CarService {

    private static CarService instance = null;

    public static CarService getInstance() {
        if(instance == null) {
            instance = new CarService();
        }
        return instance;
    }

    private CarService() {}

    public void carGoing(Car c1) throws InterruptedException {
        while(c1.getFuel() != 0) {
            delay();
            c1.deincrementFuel();
            System.out.println("stan paliwa: " + c1.getFuel());
        }


    }

    public void carStop() {

    }

    public void addFuel(Car c1) {
        int value = c1.getFuel() + 1;
        c1.setFuel(value);
    }

    private void delay() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(300);
    }


}
