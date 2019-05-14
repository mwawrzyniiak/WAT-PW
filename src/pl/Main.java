package pl;

import pl.entity.Distributor;
import pl.entity.DistributorQueue;
import pl.entity.Station;
import pl.service.CarGenerator;

public class Main {
    public static void main(String[] args) {
        //Test działania wątków:
        CarGenerator carGenerator = new CarGenerator();
        Distributor distributor1 = new Distributor();
        Distributor distributor2 = new Distributor();
        Distributor distributor3 = new Distributor();
        Distributor distributor4 = new Distributor();
        Distributor distributor5 = new Distributor();
        Distributor distributor6 = new Distributor();
        Distributor distributor7 = new Distributor();
        Distributor distributor8 = new Distributor();
        carGenerator.start();
        distributor1.start();
        distributor2.start();
        distributor3.start();
        distributor4.start();
        distributor5.start();
        distributor6.start();
        distributor7.start();
        distributor8.start();
    }



}
