
public abstract class Robot {
	private String name;

	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	abstract public void attack();

	abstract public void move();
}
