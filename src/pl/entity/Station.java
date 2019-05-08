package pl.entity;

public class Station extends Thread{

    private Distributor[] distributors = new Distributor[16];

    public Station() {
        creatingDistributors();
    }

    private void creatingDistributors() {
        for(int i = 0; i < distributors.length; i++) {
            distributors[i] = new Distributor();
        }
    }

    public Distributor getDistributor(int ID) {
        return distributors[ID];
    }

    public void toStringDistributors() {
        for(int i = 0; i < distributors.length; i++) {
            System.out.println("Distributor ID: " + distributors[i].getDispenserID() + ", have: " + distributors[i].getDispenserCapacity() + " fuel!");
        }
    }

}
