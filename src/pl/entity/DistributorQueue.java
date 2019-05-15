package pl.entity;


/*
    Kolejka do dystrybutora jest sekcją krytyczną.
    Każda para dystrybutorów n oraz n+1 posiada jedną, tą samą kolejkę
    Sekcja krytyczna obsługiwana jest przez Wątek generowania samohodow oraz przez wątek każdego dystrybutora.
    Ustalamy zasadę, że samochód zawsze podjeżdża pod dystrybutor który stoi dalej, i nie blokuje dystrybutora
*/

import java.util.LinkedList;

//TODO: JAKIE DYSTRYBUTORY NALEZA DO DISTRIBUTO_RQUEUE
//TODO: sekcja krytyczna
//Sekcja krytyczna
public class DistributorQueue {

    private LinkedList<Car> distributorQueueForCar = new LinkedList<Car>();

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

    public String toString() {
        return "Kolejka nr: " + QUEUE_ID;
    }

}
