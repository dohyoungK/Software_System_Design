package StrategyPattern;

public abstract class Robot {
	private String name;
	private AttackInterface attacking;
	private MoveInterface moving;
	
	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void attack() {
		attacking.attack();
	}

	public void move() {
		moving.move();
	}
	
	public void setAttacking(AttackInterface attacking) {
		this.attacking = attacking;
	}
	
	public void setMoving(MoveInterface moving) {
		this.moving = moving;
	}
}
