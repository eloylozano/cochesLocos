package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

import java.util.Random;

public class Car extends DrivenVehicleAbstract {

    private int number;
    private String driver;
    private int maxSpeed;
    private String description;
    private int currentSpeed;
    private int[] gearSpeeds;
    private String drivingStyle;

    public Car(int number, String driver, int maxSpeed, String description, int[] gearSpeeds, String drivingStyle) {
        this.number = number;
        this.driver = driver;
        this.maxSpeed = maxSpeed;
        this.description = description;
        this.gearSpeeds = gearSpeeds;
        this.drivingStyle = drivingStyle;
        this.currentSpeed = 0;
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
        String result = "";

        switch (drivingStyle) {
            case "Normal":
                break;
            case "Aggressive":
                maxSpeed *= random.nextInt(1) + 0.2;
                break;
            case "Cautious":
                maxSpeed *= random.nextDouble() * 0.8 + 0.2;
                break;
        }

        // Calculate current gear based on current speed
        int currentGear = calculateCurrentGear();

        // Determine the maximum speed for the current gear
        int maxSpeedForGear = maxSpeedForGear(currentGear);

        // Adjust current speed based on the maximum speed for the current gear
        if (nextSection.getRealMaxSpeed() > maxSpeedForGear) {
            currentSpeed = maxSpeedForGear;
            result += "Cambia a " + currentGear + ", alcanzando la velocidad de  " + maxSpeedForGear + " km/h.";
        } else {
            currentSpeed = nextSection.getTheoreticalMaxSpeed();
            result += "Se mantiene en " + currentGear + ", ajustando la velocidad en " + currentSpeed + " km/h.";
        }

        return result + super.adaptSpeed();
    }

    private int calculateCurrentGear() {
        // Determine the current gear based on the speed and gear speeds
        for (int i = gearSpeeds.length - 1; i >= 0; i--) {
            if (currentSpeed <= gearSpeeds[i]) {
                return i + 1; // Add 1 because gears are 1-indexed
            }
        }
        return 1; // Return 1 if speed is lower than the lowest gear speed
    }

    private int maxSpeedForGear(int gear) {
        // Return the maximum speed for the given gear
        if (gear >= 1 && gear <= gearSpeeds.length) {
            return gearSpeeds[gear - 1];
        }
        return 0; // Return 0 for invalid gear
    }
}
