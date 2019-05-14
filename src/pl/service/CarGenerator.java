package pl.service;

import pl.entity.Car;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarGenerator extends Thread{

    private static int CAR_GENERATOR_LIMIT = 1000;
    private static int countOfCar = 0;

    private LinkedList<Car> queueOfCars = new LinkedList<>();
    private Car[] cars = new Car[CAR_GENERATOR_LIMIT];

    private boolean isQueueFull = false;

    private Random random = new Random();

    //TODO: sprawdzanie czy mozna jakis samochod przyjechac do kolejki
    public void run() {
        while(true) {
            while(!isQueueFull) {
                cars[countOfCar] = new Car();

                try {
                    Thread.sleep(randomValueOfCarCome());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                queueOfCars.add(cars[countOfCar]);
                System.out.println(queueOfCars.get(countOfCar));
                countOfCar++;


                if(queueOfCars.size() == 15) {
                    isQueueFull = true;
                }
            }
            System.out.println("A lot of cars in queue to station!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private long randomValueOfCarCome() {
        return random.nextInt(2000) + 3000;

    }

    public LinkedList<Car> getQueueOfCars() {
        return queueOfCars;
    }

}
