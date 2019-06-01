package pl.entity;

import java.util.Random;

public class Car {

    private static String shortcuts[] = {"WPN", "WP", "WO", "WP", "WW", "WSI", "PK", "PN", "PGO", "LB", "LLB", "GD", "GKW", "EP", "ERA", "CLI", "CBR", "DJ", "DOL"};

    private String registration;    //numer rejestracyjny
    private int tankCapacity;       //pojemność baku
    private int fuel;           //aktualna ilosc paliwa w baku

    private Random amountOfFuelGenerator = new Random();

    public Car() {
        this.registration = setTrueRegistration();
        Random amountOfTankCapityGenerator = new Random();
        this.tankCapacity = amountOfTankCapityGenerator.nextInt(41) + 10; //losowanie liczb z przedziału od 10 do 50.
        this.fuel = 0;
    }


    private String setTrueRegistration() {
        String RadomRegistration;

        RadomRegistration = shortcuts[new Random().nextInt(shortcuts.length)] + "-" + (new Random().nextInt(3000) + 1000);
        return RadomRegistration;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public int getFuel() {
        return fuel;
    }

    public String getRegistration() {
        return registration;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void deincrementFuel() {
        fuel--;
    }

    public void incrementFuel() {
        fuel++;
    }

    public boolean isFuelEmpty() {
        boolean isEmpty = false;
        if(getFuel() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration='" + registration + '\'' +
                ", tankCapacity=" + tankCapacity +
                ", fuel=" + fuel +
                '}';
    }
}
