package pl.entity;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carCreationTest() {
        Car car = new Car();
        boolean state = false;

        if (car.getFuel() > 0 && car.getTankCapacity() > car.getFuel()) {
            state = true;
        }
        assertTrue(state);
    }
}
