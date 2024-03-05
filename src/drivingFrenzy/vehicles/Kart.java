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
    public String adaptSpeed(Section nextSection,  double realMaxSpeed) {
        String result = "";

            if (currentGear == 1) {
                if (nextSection.getTheoreticalMaxSpeed() > maxSpeedFirstGear) {
                    currentSpeed = maxSpeedFirstGear;
                    result += "El Kart cambia a la marcha 1, alcanzando la velocidad maxima de " + maxSpeedFirstGear + " km/h.";
                    currentGear++;
                } else if (nextSection.getTheoreticalMaxSpeed() < minSpeedFirstGear) {
                    currentSpeed = minSpeedFirstGear;
                    result += "El Kart reduce la velocidad a la marcha 1 m�nima de " + minSpeedFirstGear + " km/h.";
                } else {
                    currentSpeed = nextSection.getTheoreticalMaxSpeed();
                    result += "El Kart se mantiene en la marcha 1, ajustando la velocidad a " + currentSpeed + " km/h.";
                }

            } else if (currentGear == 2) {
                if (nextSection.getTheoreticalMaxSpeed() > maxSpeedSecondGear) {
                    currentSpeed = maxSpeedSecondGear;
                    result += "El Kart cambia a la marcha 1, alcanzando la velocidad maxima de " + maxSpeedSecondGear + " km/h.";
                } else if (nextSection.getTheoreticalMaxSpeed() < minSpeedSecondGear) {
                    currentSpeed = minSpeedSecondGear;
                    result += "El Kart reduce la velocidad a la marcha 1 minima de " + minSpeedSecondGear + " km/h.";
                    currentGear--;
                } else {
                    currentSpeed = nextSection.getTheoreticalMaxSpeed();
                    result += "El Kart se mantiene en la marcha 1, ajustando la velocidad a " + currentSpeed + " km/h.";
                }

            }


            return result;
        }

        public void GearUp () {
            if (currentGear == 1) {
                currentGear = +1;
            }
        }

        public void GearDown () {
            if (currentGear == 2) {
                currentGear = -1;
            }
        }

    }
