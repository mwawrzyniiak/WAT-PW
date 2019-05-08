package pl.service;

import pl.entity.Distributor;

public class FuelSupplierService {

    public FuelSupplierService() {
    }

    public void refuelingTheDistributor(Distributor distributorToCheck) {
        if(distributorToCheck.isDistributorEmpty()) {
            while(distributorToCheck.getDispenserCapacity() < 1000) {
                distributorToCheck.incrementFuel();
            }
            System.out.println("Tankowanie dystrybutora się powiodło!");
        } else {
            System.out.println("ERROR - TANKOWANIE DYSTRYBUTORA SIE NIE POWIODŁO!");
        }
    }
}
