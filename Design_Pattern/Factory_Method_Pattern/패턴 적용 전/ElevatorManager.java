import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ElevatorManager {
	private List<ElevatorController> controllers;

	public ElevatorManager(int controllerCount) {
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for (int i = 0; i < controllerCount; i++) {
			ElevatorController controller = new ElevatorController(i + 1);
			controllers.add(controller);
		}
	}

	void requestElevator(int destination, Direction direction) {
		ElevatorScheduler scheduler;
		// 0..23
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour < 12) // 오전에는 ResponseTimeScheduler를 이용함
			scheduler = new ResponseTimeScheduler();
		else // 오후에는 ThroughtputScheduler를 이용함
			scheduler = new ThroughputScheduler();
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}