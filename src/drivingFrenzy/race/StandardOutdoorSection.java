package drivingFrenzy.race;


import java.util.Random;

/**
 * @author ismael
 * This type of section is not affected by climate or any effects.
 */
public class StandardOutdoorSection implements Section {

    private int length;
    private String description;
    private static int theoreticalMaxSpeed;
    private static double realMaxSpeed;
    private static String climate;

    public StandardOutdoorSection(int length, String description, int theoreticalMaxSpeed, String climate) {
        super();
        this.length = length;
        this.description = description;
        this.theoreticalMaxSpeed = theoreticalMaxSpeed;
        this.climate = climate;
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
        return realMaxSpeed;
    }

    public static String getRandomClimate() {
        Random random = new Random();
        int climateRandom = random.nextInt(3);
        if (climateRandom == 0) {
            // 0 == Rainy, worst conditions to race
            double speedRainyCoefficient = random.nextDouble(0.2) + 0.7;
            realMaxSpeed = theoreticalMaxSpeed * speedRainyCoefficient;
        } else if (climateRandom == 1) {
            // 1 == Normal or Cloudy
            double speedNormalCoefficient = random.nextDouble(0.2) + 0.9;
            realMaxSpeed = theoreticalMaxSpeed * speedNormalCoefficient;
        } else if (climateRandom == 2) {
            // 2 == Sunny, better conditions to race
            double speedSunnyCoefficient = random.nextDouble(0.2) + 1.1;
            realMaxSpeed = theoreticalMaxSpeed * speedSunnyCoefficient;
        }
        return climate;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
