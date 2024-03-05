package drivingFrenzy.race;


import java.util.Random;

/**
 * @author ismael
 * This type of section is not affected by climate or any effects.
 */
public class StandardOutdoorSection implements Section {

    private int length;
    private String description;
    private int theoreticalMaxSpeed;
    private String climate;
    private double realMaxSpeed;

    public StandardOutdoorSection(int length, String description, int theoreticalMaxSpeed, String climate, double realMaxSpeed) {
        this.length = length;
        this.description = description;
        this.theoreticalMaxSpeed = theoreticalMaxSpeed;
        this.climate = climate;
        this.realMaxSpeed = realMaxSpeed;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getTheoreticalMaxSpeed() {
        return theoreticalMaxSpeed;
    }

    @Override
    public int getCurrentMaxSpeed() {
        return theoreticalMaxSpeed;
    }


    @Override
    public double getRealMaxSpeed() {
        switch (climate){
            case "Sunny":
                realMaxSpeed = theoreticalMaxSpeed * 1.2;
                break;
            case "Normal":
                realMaxSpeed = theoreticalMaxSpeed;
                break;
            case "Rainy":
                realMaxSpeed = theoreticalMaxSpeed * 0.7;
                break;
        }
        return realMaxSpeed;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
