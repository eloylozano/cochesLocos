package drivingFrenzy.race;


/**
 * @author ismael
 * This type of section is not affected by climate or any effects. 
 */
public class StandardOutdoorSection implements Section{

	private int length;
	private String description;
	private int theoreticalMaxSpeed;
	private double realMaxSpeed;
	private String[] climate = {"Rainy", "Cloudy", "Sunny"};


	public StandardOutdoorSection(int length, String description, int theoreticalMaxSpeed, String[] climate) {
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
		if (climate.equals("Rainy")) {
			realMaxSpeed = theoreticalMaxSpeed * 0.7;
		} else if (climate.equals("Cloudy")) {
			realMaxSpeed = theoreticalMaxSpeed * 0.9;
		} else if (climate.equals("Sunny")) {
			realMaxSpeed = theoreticalMaxSpeed * 1.1;
		}
		return realMaxSpeed;
	}


	@Override
	public String getDescription() {
		return description;
	}

}
