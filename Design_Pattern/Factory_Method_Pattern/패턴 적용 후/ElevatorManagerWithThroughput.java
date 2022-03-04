package ElevatorFactoryMethod;

public class ElevatorManagerWithThroughput extends ElevatorManager{
	public ElevatorManagerWithThroughput(int controllerCount) {
		super(controllerCount);
	}
	
	@Override
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ThroughputScheduler.getInstance();
		return scheduler;
	}
}
