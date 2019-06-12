package pl.service;

import pl.entity.Distributor;

public class FuelSupplierService {

    public FuelSupplierService() {
    }

    public synchronized void refuelingTheDistributor(Distributor distributorToCheck) {
        if(distributorToCheck.isDistributorEmpty()) {
            while(distributorToCheck.getDispenserCapacity() < 1000) {
                distributorToCheck.incrementFuel();
            }
            System.out.println();
            System.out.println("[CYSTERNA] Tankowanie dystrybutora się powiodło!" + distributorToCheck.toString());
            System.out.println();
        } else {
            System.out.println("ERROR - TANKOWANIE DYSTRYBUTORA SIE NIE POWIODŁO!");
        }
    }
}
