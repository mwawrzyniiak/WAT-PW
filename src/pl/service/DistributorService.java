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





}
