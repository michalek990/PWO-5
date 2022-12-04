package org.example.Zadanie_1;

public class Transaction {
    private int paid;
    private int earned;

    public int getPaid() {
        return 1000;
    }

    public int getEarned() {
        return 1000;
    }

    public String getName() {
        return "Paweł";
    }

    public String getSurname() {
        return "Paweł";
    }

    public String longOperation(){
        try {
            Thread.sleep(5000);
            return "ok";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
