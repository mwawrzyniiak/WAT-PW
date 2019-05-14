package pl.entity;


/*
    Kolejka do dystrybutora jest sekcją krytyczną.
    Każda para dystrybutorów n oraz n+1 posiada jedną, tą samą kolejkę
    Sekcja krytyczna obsługiwana jest przez Wątek generowania samohodow oraz przez wątek każdego dystrybutora.
    Ustalamy zasadę, że samochód zawsze podjeżdża pod dystrybutor który stoi dalej, i nie blokuje dystrybutora
*/

import java.util.LinkedList;
import java.util.Random;

//TODO: sekcja krytyczna
//Sekcja krytyczna
public class DistributorQueue extends Thread{

    private static final boolean WORK = true;

    private LinkedList<Car> distributorQueueForcar = new LinkedList<Car>();
    private Integer QUEUE_ID;
    private Random random = new Random();

    public DistributorQueue(Integer QUEUE_ID) {
        this.QUEUE_ID = QUEUE_ID;
    }

    public void run() {
        while(WORK) {
            canITakeCar();
            try {
                Thread.sleep(random.nextInt(1500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO: SPRAWDZA CZY JEST DOSTEPNY SAMOCHOD
    public boolean canITakeCar() {
        System.out.println("SPRAWDZAM CZY MOGE WZIAC SAMOCHOD" + QUEUE_ID);
        return true;
    }
}
