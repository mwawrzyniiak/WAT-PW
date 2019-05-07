package pl.service;

import org.junit.jupiter.api.Test;
import pl.entity.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void addFuel() {
        Car c1 = new Car();
        CarService carService = CarService.getInstance();
        int afterAddfuel = c1.getFuel()+1;
        carService.addFuel(c1);
        int afterAddFuelFunc = c1.getFuel();

        assertEquals(afterAddfuel, afterAddFuelFunc);
    }
}
