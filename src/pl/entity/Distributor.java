package pl.entity;

import java.util.Random;

public class Distributor extends Thread {

    private int dispenserCapacity;                  //aktualna pojemność dystrybutora [max 1000]
    private int dispenserID;                        //Unikalne ID dystrybutora
    private static int lastDispenserID = 1;         //Zmienna pomocnicza do wyznaczania kolejnego ID
    private boolean WORK_STATUS = true;

    private Random random = new Random();

    public Distributor() {
        dispenserCapacity = setRandomDispenserCapacity();
        dispenserID = lastDispenserID;
        incrementID();
    }

    private int setRandomDispenserCapacity() {
        Random randomDispenserCapacity = new Random();
        return randomDispenserCapacity.nextInt(500) + 500;
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
        while(WORK_STATUS) {
            System.out.println("Dystrybutor: " + dispenserID);
            try {
                Thread.sleep(random.nextInt(1500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "dispenserCapacity=" + dispenserCapacity +
                ", dispenserID=" + dispenserID +
                '}';
    }
}
