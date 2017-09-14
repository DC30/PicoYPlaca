package picoplaca;

import java.time.LocalTime;

public class MainPredictor {
	
	private PicoYPlaca picoPlaca;
	
	
	public MainPredictor() {
	picoPlaca = new PicoYPlaca(); 
	}

	public static void main(String[] args) {
		MainPredictor predictor = new MainPredictor();
		System.out.println(predictor.allowedOnRoad("ABC0198", "13-09-2017", LocalTime.parse("19:10")));
					
	}
	
	/**
	 * Predict if a car is allowed on the road
	 * @param plate ABC0123
	 * @param date dd-MM-yyyy
	 * @param time format 24H HH:MM
	 * @return if the car can be on the road or not
	 */

	public String allowedOnRoad(String plate, String date, LocalTime time){
		if(picoPlaca.isValidPlate(plate)){
			if(picoPlaca.isDailyAllowedByPlate(plate, date) && picoPlaca.isRestrictedSchedule(time))
				return "Car is not allowed on road is Pico y Placa";
			return "Car can be on road";			
		}
		return "There is a problem with the plate";
	}

}
