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
        Random random = new Random();
        climate = random.nextInt(3);
        double speedCoefficent = 0;
        switch (climate) {
            case 0:
                speedCoefficent = random.nextDouble(0.7) + 0.2;
                realMaxSpeed = theoreticalMaxSpeed * speedCoefficent;
                break;
            case 1:
                speedCoefficent = random.nextDouble(0.9) + 0.2;
                realMaxSpeed = theoreticalMaxSpeed * speedCoefficent;
                break;
            case 2:
                speedCoefficent = random.nextDouble(1.1) + 0.2;
                realMaxSpeed = theoreticalMaxSpeed * speedCoefficent;
                break;
        }
        return realMaxSpeed;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
