package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

public class Kart implements Vehicle {

    private int number;
    private String driver;
    private int currentSpeed;
    private int maxSpeed;
    private String description;
    private int currentGear;
    private int minSpeedFirstGear;
    private int maxSpeedFirstGear;
    private int minSpeedSecondGear;
    private int maxSpeedSecondGear;

    public Kart(int number, String driver, int currentSpeed, int maxSpeed, String description, int currentGear, int minSpeedFirstGear, int maxSpeedFirstGear, int minSpeedSecondGear, int maxSpeedSecondGear) {
        this.number = number;
        this.driver = driver;
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
        this.description = description;
        this.currentGear = currentGear;
        this.minSpeedFirstGear = minSpeedFirstGear;
        this.maxSpeedFirstGear = maxSpeedFirstGear;
        this.minSpeedSecondGear = minSpeedSecondGear;
        this.maxSpeedSecondGear = maxSpeedSecondGear;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String adaptSpeed(Section nextSection) {
        String result = "";


        if (currentGear == 1){
            if (nextSection.getTheoreticalMaxSpeed() > minSpeedFirstGear) {

            }

        } else if (currentGear == 2) {


        }


        return result;
    }

    public void GearUp() {
        if (currentGear == 1) {
            currentGear =+ 1;
        }
    }

    public void GearDown() {
        if (currentGear == 2) {
            currentGear =- 1;
        }
    }

}
