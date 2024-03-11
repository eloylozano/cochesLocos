package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;
import drivingFrenzy.race.StandardOutdoorSection;

import java.util.Random;

public class Kart extends DrivenVehicleAbstract {

    private int number;
    private String driver;
    private int maxSpeed;
    private String description;
    private int currentGear;
    private int minSpeedFirstGear;
    private int maxSpeedFirstGear;
    private int minSpeedSecondGear;
    private int maxSpeedSecondGear;
    private String drivingStyle;

    public Kart(int number, String driver, int currentSpeed, int maxSpeed, String description, int currentGear, int minSpeedFirstGear, int maxSpeedFirstGear, int minSpeedSecondGear, int maxSpeedSecondGear, String drivingStyle) {
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
        this.drivingStyle = drivingStyle;
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
    public String adaptSpeed(Section nextSection, double realMaxSpeed) {
        return null;
    }

    @Override
    public String adaptSpeed(Section nextSection) {
        Random random = new Random();
        int randomBound = 0;
        switch (drivingStyle) {
            case "Normal":
                break;
            case "Agressive":
            case "Cautious":
                randomBound = nextSection.getVariationLevel();
                maxSpeed *= random.nextInt() * randomBound + 1;
                break;
        }

        String result = "";
        if (currentGear == 1) {
            if (nextSection.getRealMaxSpeed() > maxSpeedFirstGear) {
                currentSpeed = maxSpeedFirstGear;
                result += "El Kart cambia a la marcha 1, alcanzando la velocidad maxima de " + maxSpeedFirstGear + " km/h.";
                currentGear++;
            } else if (nextSection.getRealMaxSpeed() < minSpeedFirstGear) {
                currentSpeed = minSpeedFirstGear;
                result += "El Kart reduce la velocidad a la marcha 1 minima de " + minSpeedFirstGear + " km/h.";
            } else {
                currentSpeed = nextSection.getTheoreticalMaxSpeed();
                result += "El Kart se mantiene en la marcha 1, ajustando la velocidad a " + maxSpeedFirstGear + " km/h.";
            }
        } else if (currentGear == 2) {
            if (nextSection.getRealMaxSpeed() > maxSpeedSecondGear) {
                currentSpeed = maxSpeedSecondGear;
                result += "El Kart cambia a la marcha 2, alcanzando la velocidad maxima de " + maxSpeedSecondGear + " km/h.";
            } else if (nextSection.getRealMaxSpeed() < minSpeedSecondGear) {
                currentSpeed = minSpeedSecondGear;
                result += "El Kart reduce la velocidad a la marcha 1 minima de " + minSpeedSecondGear + " km/h.";
                currentGear--;
            } else {
                currentSpeed = nextSection.getTheoreticalMaxSpeed();
                result += "El Kart se mantiene en la marcha 1, ajustando la velocidad a " + maxSpeedSecondGear + " km/h.";
            }
        }

        return result + super.adaptSpeed();
    }
}
