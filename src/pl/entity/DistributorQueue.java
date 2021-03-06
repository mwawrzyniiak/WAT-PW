package pl.entity;


/*
    Kolejka do dystrybutora jest sekcją krytyczną.
    Każda para dystrybutorów n oraz n+1 posiada jedną, tą samą kolejkę
    Sekcja krytyczna obsługiwana jest przez Wątek generowania samohodow oraz przez wątek każdego dystrybutora.
    Ustalamy zasadę, że samochód zawsze podjeżdża pod dystrybutor który stoi dalej, i nie blokuje dystrybutora
*/

import java.util.LinkedList;
import java.util.Queue;

//TODO: JAKIE DYSTRYBUTORY NALEZA DO DISTRIBUTO_RQUEUE
//TODO: sekcja krytyczna
//Sekcja krytyczna
public class DistributorQueue {

    private Queue<Car> distributorQueueForCar = new LinkedList<Car>();

    private Integer QUEUE_ID;

    public DistributorQueue(Integer QUEUE_ID) {
        this.QUEUE_ID = QUEUE_ID;
    }


    public boolean isEmpty() {
        boolean status = false;
        status = distributorQueueForCar.isEmpty();
        return status;
    }

    //METODO KTORA POWSTALA TYLKO DO TESTOW!
    public void addCarToQueue(Car car) {
        distributorQueueForCar.add(car);
    }

    //Metoda która pobiera pierwszy samochod w kolejce a nastepnie go usuwa z kolejki
    public Car getCarFromQueue() {
        Car carToPoll = null;
        if(distributorQueueForCar.isEmpty()) {
            System.out.println("ERROR- ''getCarFromQueue''- KOLEJKA JEST PUSTA! ");
        } else {
            carToPoll = distributorQueueForCar.poll();
        }
        return carToPoll;
    }

    public String toString() {
        return "Kolejka nr: " + QUEUE_ID;
    }

}
