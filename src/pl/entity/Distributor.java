package pl.entity;

import java.util.Random;

public class Distributor {

    private int dispenserCapacity;                  //aktualna pojemność dystrybutora [max 1000]
    private int dispenserID;                        //Unikalne ID dystrybutora
    private static int lastDispenserID = 1;         //Zmienna pomocnicza do wyznaczania kolejnego ID

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


    @Override
    public String toString() {
        return "Distributor{" +
                "dispenserCapacity=" + dispenserCapacity +
                ", dispenserID=" + dispenserID +
                '}';
    }
}
