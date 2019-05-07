package pl.service;

public class DistributorService {

    private static DistributorService instance = null;

    public static DistributorService getInstance() {
        if(instance == null) {
            instance = new DistributorService();
        }
        return instance;
    }



}
