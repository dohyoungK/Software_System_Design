package ElevatorFactoryMethod;

public class ElevatorManagerWithResponseTime extends ElevatorManager{
	public ElevatorManagerWithResponseTime(int controllerCount) {
		super(controllerCount);
	}
	
	@Override
	protected ElevatorScheduler getScheduler() {
		ElevatorScheduler scheduler = ResponseTimeScheduler.getInstance();
		return scheduler;
	}
}
