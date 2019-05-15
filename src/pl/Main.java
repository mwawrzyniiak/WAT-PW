package pl;

import pl.entity.Car;
import pl.entity.Distributor;
import pl.entity.DistributorQueue;
import pl.service.CarGenerator;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        List<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);

        System.out.println(testList);


        //Generowanie sekcji krytycznej
        List<DistributorQueue> distributorQueues = main.createDistributorQueue();

        //Tworzenie dystrybutorow wraz z przydzieleniem kolejki do niego
        List<Distributor> distributorList = main.createDistributorsWithQueue(distributorQueues);

        //WĄTEK GENEROWANIA SAMOCHODOW
        CarGenerator carGenerator = new CarGenerator(distributorQueues);

        //uruchomienie wszystkich dystrybutorow
        main.distributorThreadStart(distributorList);

        //uruchomienie generowania samochodow
        carGenerator.start();


    }

    private List<DistributorQueue> createDistributorQueue() {
        List<DistributorQueue> distributorQueues = new LinkedList<>();
        DistributorQueue distributorQueue1 = new DistributorQueue(1);
        DistributorQueue distributorQueue2 = new DistributorQueue(2);
        DistributorQueue distributorQueue3 = new DistributorQueue(3);
        DistributorQueue distributorQueue4 = new DistributorQueue(4);
        DistributorQueue distributorQueue5 = new DistributorQueue(5);
        DistributorQueue distributorQueue6 = new DistributorQueue(6);
        DistributorQueue distributorQueue7 = new DistributorQueue(7);
        DistributorQueue distributorQueue8 = new DistributorQueue(8);

        distributorQueues.add(distributorQueue1);
        distributorQueues.add(distributorQueue2);
        distributorQueues.add(distributorQueue3);
        distributorQueues.add(distributorQueue4);
        distributorQueues.add(distributorQueue5);
        distributorQueues.add(distributorQueue6);
        distributorQueues.add(distributorQueue7);
        distributorQueues.add(distributorQueue8);
        return distributorQueues;
    }

    private List<Distributor> createDistributorsWithQueue(List<DistributorQueue> distributorQueues) {
        //WĄTKI DYSTRYBUTORÓW
        List<Distributor> distributorsList = new LinkedList<>();
        Distributor distributor1 = new Distributor(distributorQueues.get(0));
        Distributor distributor2 = new Distributor(distributorQueues.get(0));
        Distributor distributor3 = new Distributor(distributorQueues.get(1));
        Distributor distributor4 = new Distributor(distributorQueues.get(1));
        Distributor distributor5 = new Distributor(distributorQueues.get(2));
        Distributor distributor6 = new Distributor(distributorQueues.get(2));
        Distributor distributor7 = new Distributor(distributorQueues.get(3));
        Distributor distributor8 = new Distributor(distributorQueues.get(3));
        Distributor distributor9 = new Distributor(distributorQueues.get(4));
        Distributor distributor10 = new Distributor(distributorQueues.get(4));
        Distributor distributor11 = new Distributor(distributorQueues.get(5));
        Distributor distributor12 = new Distributor(distributorQueues.get(5));
        Distributor distributor13 = new Distributor(distributorQueues.get(6));
        Distributor distributor14 = new Distributor(distributorQueues.get(6));
        Distributor distributor15 = new Distributor(distributorQueues.get(7));
        Distributor distributor16 = new Distributor(distributorQueues.get(7));

        distributorsList.add(distributor1);
        distributorsList.add(distributor2);
        distributorsList.add(distributor3);
        distributorsList.add(distributor4);
        distributorsList.add(distributor5);
        distributorsList.add(distributor6);
        distributorsList.add(distributor7);
        distributorsList.add(distributor8);
        distributorsList.add(distributor9);
        distributorsList.add(distributor10);
        distributorsList.add(distributor11);
        distributorsList.add(distributor12);
        distributorsList.add(distributor13);
        distributorsList.add(distributor14);
        distributorsList.add(distributor15);
        distributorsList.add(distributor16);

        return distributorsList;
    }

    private void distributorThreadStart(List<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            distributor.start();
            System.out.println("Distributor Thread: " + distributor.getDispenserID() + " START!");
        }
    }


}
