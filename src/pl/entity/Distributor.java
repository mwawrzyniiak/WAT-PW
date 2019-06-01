package pl.entity;

import pl.service.DistributorService;
import pl.service.FuelSupplierService;

import java.util.Random;

public class Distributor extends Thread {

    private int dispenserCapacity;                  //aktualna pojemność dystrybutora [max 1000]
    private int dispenserID;                        //Unikalne ID dystrybutora
    private static int lastDispenserID = 1;         //Zmienna pomocnicza do wyznaczania kolejnego ID
    private boolean WORK_STATUS = false;
    private DistributorQueue distributorQueues;
    private FuelSupplierService fuelSupplierService = new FuelSupplierService();

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

    private void deincrementFuel() {
        dispenserCapacity--;
    }

    public void incrementFuel() {
        dispenserCapacity++;
    }

    public void run() {
        while (true) {

            //sekcja glowna
            while (WORK_STATUS) {
                //jezeli kolejka jest pusta wychodzi z sekcji glownej
                carService();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println("KOLEJKA DO DYSTRYBUTORA: " + dispenserID + " JEST PUSTA!" + " Jego nr Kolejki to: " + distributorQueues);
            //Jezeli kolejka nie jest pusta pozwala wejsc do sekji glownej
            WORK_STATUS = !distributorQueues.isEmpty();
        }
    }

    private synchronized void carService()  {
        if (distributorQueues.isEmpty()) {
            WORK_STATUS = false;
        } else {
            Car car = distributorQueues.getCarFromQueue();
            System.out.println("POBIERAM SAMOCHOD Z " + distributorQueues.toString() + ", samochod: " + car.toString());
            tankCar(car, fuelSupplierService);
            try {
                Thread.sleep(random.nextInt(1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public DistributorQueue getDistributorQueues() {
        return distributorQueues;
    }

    private void tankCar(Car c1, FuelSupplierService f1)  {
        if (c1.getFuel() == 0) {
            while (c1.getFuel() != c1.getTankCapacity()) {
                if (this.getDispenserCapacity() != 0) {
                    this.deincrementFuel();
                } else {
                    f1.refuelingTheDistributor(this);
                    this.deincrementFuel();
                }

                int value = c1.getFuel() + 1;
                if (value == 0) {
                    value = 1;
                }
                c1.setFuel(value);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("TANKOWANIE - AKTUALNY STAN PALIWA SAMOCHODU: " + c1.getFuel() + ", samochod: " + c1.toString());
                System.out.println("TANKOWANIE - AKTUALNY STAN DYSTRYBUTORA: " + this.getDispenserCapacity());
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
