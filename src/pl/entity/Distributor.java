package pl.entity;

import java.util.Random;

public class Distributor extends Thread {

    private int dispenserCapacity;                  //aktualna pojemność dystrybutora [max 1000]
    private int dispenserID;                        //Unikalne ID dystrybutora
    private static int lastDispenserID = 1;         //Zmienna pomocnicza do wyznaczania kolejnego ID
    private boolean WORK_STATUS = false;
    private DistributorQueue distributorQueues;

    private Random random = new Random();

    public Distributor(DistributorQueue distributorQueues) {
        dispenserCapacity = setRandomDispenserCapacity();
        dispenserID = lastDispenserID;
        incrementID();
        this.distributorQueues = distributorQueues;
    }

    private int setRandomDispenserCapacity() {
        Random randomDispenserCapacity = new Random();
        return randomDispenserCapacity.nextInt(1500) + 1500;
    }

    private void incrementID() {
        lastDispenserID++;
    }

    public int getDispenserCapacity() {
        return dispenserCapacity;
    }

    public int getDispenserID() {
        return dispenserID;
    }

    public boolean isDistributorEmpty() {
        boolean isEmpty = false;
        if(getDispenserCapacity() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public void deincrementFuel() {
        dispenserCapacity--;
    }

    public void incrementFuel() {
        dispenserCapacity++;
    }

    public void run() {
        while (true) {

            //sekcja glowna
            while (WORK_STATUS) {
                System.out.println("Dystrybutor: " + dispenserID + " Posiada w kolejce samochody do obsluzenia!" + " Jego nr Kolejki to: " + distributorQueues.toString());

                try {
                    Thread.sleep(random.nextInt(1000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //jezeli kolejka jest pusta wychodzi z sekcji glownej
                if (distributorQueues.isEmpty()) {
                    WORK_STATUS = false;
                }

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("KOLEJKA DO DYSTRYBUTORA: " + dispenserID + " JEST PUSTA!" + " Jego nr Kolejki to: " + distributorQueues);
            //Jezeli kolejka nie jest pusta pozwala wejsc do sekji glownej
            if (distributorQueues.isEmpty()) {
                WORK_STATUS = false;
            } else {
                WORK_STATUS = true;
            }
        }
    }

    public DistributorQueue getDistributorQueues() {
        return distributorQueues;
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "dispenserCapacity=" + dispenserCapacity +
                ", dispenserID=" + dispenserID +
                '}';
    }
}
