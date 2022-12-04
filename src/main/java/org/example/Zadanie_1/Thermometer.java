package org.example.Zadanie_1;

public class Thermometer {
    int minTemp;
    int maxTemp;
    Integer currentTemp;

    public Thermometer(int minTemp, int maxTemp){
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public static Thermometer createInstance(int minTemp, int maxTemp) {
        return new Thermometer(minTemp, minTemp);
    }

    public Integer getCurrentTemp(){
        return currentTemp;
    }


    public void setCurrentTemp(Integer currentTemp){
        this.currentTemp = currentTemp;
    }

    public void setCurrentTemp(String currentTemp){
        this.currentTemp = Integer.parseInt(currentTemp);
    }

    public int addDegrees(int degrees){
        currentTemp+=degrees;
        return currentTemp;
    }

    public int subtractDegrees(int degrees){
        currentTemp-=degrees;
        return currentTemp;
    }

    public boolean isBelowZero(){
        return currentTemp<0;
    }
}
