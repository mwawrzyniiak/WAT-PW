package pl.service;

import pl.entity.Car;
import pl.entity.DistributorQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CarGenerator extends Thread implements Runnable {

    private static int CAR_GENERATOR_LIMIT = 1000;

    private Random random = new Random();
    private Car[] cars = new Car[CAR_GENERATOR_LIMIT];
    private boolean isQueueFull = false;
    private List<DistributorQueue> distributorQueues;

    public CarGenerator(List<DistributorQueue> distributorQueues) {
        this.distributorQueues = distributorQueues;
    }

    public void run() {
        System.out.println("---");
        System.out.println("CAR GENERATOR THREAD RUN!");
        System.out.println("---");

        while (true) {
            while (!isQueueFull) {
                addingCar();
            }

            System.out.println("A lot of cars in queue to station!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (distributorQueues.size() < 4) {
                isQueueFull = false;
            }
        }
    }

    private synchronized void addingCar() {
        int countOfCar = 0;
        cars[countOfCar] = new Car();
        int value = randomQueueValue();
        try {
            Thread.sleep(randomValueOfCarCome());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        distributorQueues.get(value).addCarToQueue(cars[countOfCar]);
        System.out.println("Dodałem samochod do kolejki: " + distributorQueues.get(value).toString() + " Samochod: " + cars[countOfCar].toString());
        if (distributorQueues.size() == 4) {
            isQueueFull = true;
        }
    }

    private long randomValueOfCarCome() {
        return random.nextInt(100) + 300;
    }

    private int randomQueueValue() {
        return random.nextInt(8);
    }

}
