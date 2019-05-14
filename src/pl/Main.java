package pl;

import pl.entity.Station;
import pl.service.CarGenerator;

public class Main {
    public static void main(String[] args) {
        CarGenerator carGenerator = new CarGenerator();
        carGenerator.start();
    }



}
