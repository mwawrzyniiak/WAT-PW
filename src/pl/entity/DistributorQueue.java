package pl.entity;


/*
    Kolejka do dystrybutora jest sekcją krytyczną.
    Każda para dystrybutorów n oraz n+1 posiada jedną, tą samą kolejkę
    Sekcja krytyczna obsługiwana jest przez Wątek generowania samohodow oraz przez wątek każdego dystrybutora.
    Ustalamy zasadę, że samochód zawsze podjeżdża pod dystrybutor który stoi dalej, i nie blokuje dystrybutora
*/

import java.util.LinkedList;

//TODO: sekcja krytyczna
//Sekcja krytyczna
public class DistributorQueue {

    private LinkedList<Car> distributorQueueForcar = new LinkedList<Car>();
    private Integer QUEUE_ID;

    public DistributorQueue(Integer QUEUE_ID) {
        this.QUEUE_ID = QUEUE_ID;
    }
}
