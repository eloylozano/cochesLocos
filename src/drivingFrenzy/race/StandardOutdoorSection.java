package drivingFrenzy.race;


/**
 * @author ismael
 * This type of section is not affected by climate or any effects. 
 */
public class StandardOutdoorSection implements Section{

	private int length;
	private String description;
	private int theoreticalMaxSpeed;
	private int realMaxSpeed;


	public StandardOutdoorSection(int length, String description, int theoreticalMaxSpeed, int realMaxSpeed) {
		super();
		this.length = length;
		this.description = description;
		this.theoreticalMaxSpeed = theoreticalMaxSpeed;
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
	public String getDescription() {
		return description;
	}

}
