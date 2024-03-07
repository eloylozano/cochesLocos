package drivingFrenzy.vehicles;

import java.util.Random;

public abstract class DrivenVehicleAbstract implements Vehicle {
    private int currentSpeed;


    public String adaptSpeed() {
        Random random = new Random();
        String result = "";
        double driverError = random.nextDouble(0.8,1.1);

        System.out.println();
        if (driverError < 1) {
            result += "El piloto comete un error y reduce su velocidad a: " + currentSpeed * driverError + " km/h";
        }
        return result;
    }
}