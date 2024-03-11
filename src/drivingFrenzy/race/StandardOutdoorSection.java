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
    private double realMaxSpeed;
    private double[] coefficients;
    private int climate;

    public StandardOutdoorSection(int length, String description, int theoreticalMaxSpeed, int climate) {
        this.length = length;
        this.description = description;
        this.theoreticalMaxSpeed = theoreticalMaxSpeed;
        this.climate = climate;
        this.coefficients = generateClimate();
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

    private double[] generateClimate() {
        Random random = new Random();
        double rainyConditionsCoefficient = random.nextDouble() * 0.7 + 0.2; // Coefficient range for rainy conditions
        double normalConditionsCoefficient = random.nextDouble() * 0.9 + 0.3; // Coefficient range for normal conditions
        double sunnyConditionsCoefficient = random.nextDouble() * 1.2 + 0.2; // Coefficient range for sunny conditions

        // Store the coefficients in an array
        double[] conditions = new double[3];
        conditions[0] = rainyConditionsCoefficient;
        conditions[1] = normalConditionsCoefficient;
        conditions[2] = sunnyConditionsCoefficient;

        return conditions;
    }

    @Override
    public int getVariationLevel() {
        int variationLvl = 0;
        if (climate == 0) { // Rainy
            variationLvl = 1;
        } else if (climate == 1) { // Normal
            variationLvl = 0;
        } else if (climate == 2) { // Sunny
            variationLvl = 2;
        }
        return variationLvl;
    }

    @Override
    public double getRealMaxSpeed() {
        // Use the appropriate coefficient based on the climate
        double coefficient = coefficients[climate];
        return theoreticalMaxSpeed * coefficient;
    }

    @Override
    public String getDescription() {
        return description;
    }
}