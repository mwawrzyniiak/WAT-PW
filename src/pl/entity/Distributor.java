package pl.entity;

import java.util.Random;

public class Distributor {

    private int dispenserCapacity;                  //pojemność dystrybutora
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

    public boolean isDistributorEmpty(Distributor distributor) {
        boolean isEmpty = true;
        if(distributor.getDispenserCapacity() == 0) {
            isEmpty = false;
        }
        return isEmpty;
    }

    public void deincrementFuel() {
        this.dispenserCapacity = dispenserCapacity-1;
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "dispenserCapacity=" + dispenserCapacity +
                ", dispenserID=" + dispenserID +
                '}';
    }
}
