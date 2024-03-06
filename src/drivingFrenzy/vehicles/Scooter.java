package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

public class Scooter implements Vehicle {

	private int number;
	private String driver;
	private int currentSpeed;
	private int maxSpeed;
	private String description;

	public Scooter(int number, String driver, int currentSpeed, int maxSpeed, String description) {
		super();
		this.number = number;
		this.driver = driver;
		this.currentSpeed = currentSpeed;
		this.maxSpeed = maxSpeed;
		this.description = description;
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
		String result = "";

		if (nextSection.getRealMaxSpeed() > maxSpeed) {
			int nextSpeed =  Math.min(maxSpeed, nextSection.getTheoreticalMaxSpeed());
			result += "El número " + number + " acelera desde " + currentSpeed + " a " + nextSpeed + ". ";
			currentSpeed = nextSpeed;

			if (maxSpeed == currentSpeed) {
				result += driver + " aprieta a fondo, pero su " + description + " está al límite!";
			}
		} else {
			currentSpeed = Math.min(maxSpeed, nextSection.getTheoreticalMaxSpeed());
			result += "El número " + number + " se mantiene a " + currentSpeed + " km/h.";
		}
		return result;
	}
}