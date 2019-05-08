package pl.service;

import pl.entity.Car;
import pl.entity.Distributor;

public class DistributorService {

    private static DistributorService instance = null;

    public static DistributorService getInstance() {
        if(instance == null) {
            instance = new DistributorService();
        }
        return instance;
    }

    public void tankCar(Car c1, Distributor d1, FuelSupplierService f1) {
        if(c1.getFuel() == 0) {
            while (c1.getFuel() != c1.getTankCapacity()) {
                if(d1.getDispenserCapacity() != 0) {
                    d1.deincrementFuel();
                } else {
                    f1.refuelingTheDistributor(d1);
                    d1.deincrementFuel();
                }

                int value = c1.getFuel() + 1;
                if(value == 0) {
                    value = 1;
                }
                c1.setFuel(value);
                System.out.println("TANKOWANIE - AKTUALNY STAN PALIWA SAMOCHODU: " + c1.getFuel());
                System.out.println("TANKOWANIE - AKTUALNY STAN DYSTRYBUTORA: " + d1.getDispenserCapacity());
            }
        }
    }



}
