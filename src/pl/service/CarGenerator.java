package pl.service;

import pl.entity.Car;
import pl.entity.DistributorQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CarGenerator extends Thread{

    private static int CAR_GENERATOR_LIMIT = 1000;
    private static int countOfCar = 0;

    private Random random = new Random();
    private Car[] cars = new Car[CAR_GENERATOR_LIMIT];
    private boolean isQueueFull = false;
    private List<DistributorQueue> distributorQueues;

    public CarGenerator(List<DistributorQueue> distributorQueues) {
        this.distributorQueues = distributorQueues;
    }

    //TODO: sprawdzanie czy mozna jakis samochod przyjechac do kolejki
    public void run() {
        while(true) {
            while(!isQueueFull) {
                cars[countOfCar] = new Car();
                int value = randomQueueValue();
                try {
                    Thread.sleep(randomValueOfCarCome());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                distributorQueues.get(randomQueueValue()).addCarToQueue(cars[countOfCar]);
                System.out.println("Dodałem samochod do kolejki: " + distributorQueues.get(value).toString());
            }

            System.out.println("A lot of cars in queue to station!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private long randomValueOfCarCome() {
        return random.nextInt(2000) + 3000;
    }

    private int randomQueueValue() {
        return random.nextInt(8);
    }

}
