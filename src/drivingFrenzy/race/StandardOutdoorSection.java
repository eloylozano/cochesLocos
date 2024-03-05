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
    private int climate;
    private double realMaxSpeed;

    public StandardOutdoorSection(int length, String description, int theoreticalMaxSpeed) {
        this.length = length;
        this.description = description;
        this.theoreticalMaxSpeed = theoreticalMaxSpeed;
        this.realMaxSpeed = getRealMaxSpeed();
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
        return 0;
    }

    @Override
    public double getRealMaxSpeed() {
        Random random = new Random();
        climate = random.nextInt(3);
        double conditionsCoefficient;
        switch (climate){
            case 0: // Rainy
                conditionsCoefficient = random.nextDouble(0.6) + 0.3;
                realMaxSpeed = theoreticalMaxSpeed * conditionsCoefficient;
                break;
            case 1: // Normal
                conditionsCoefficient = random.nextDouble(0.9) + 0.3;
                realMaxSpeed = theoreticalMaxSpeed * conditionsCoefficient;
                break;
            case 2: // Sunny
                conditionsCoefficient = random.nextDouble(1.2) + 0.2;
                realMaxSpeed = theoreticalMaxSpeed * conditionsCoefficient;
                break;
        }
        return realMaxSpeed;
    }


    @Override
    public String getDescription() {
        return description;
    }

}
