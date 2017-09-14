package picoplaca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class PicoYPlaca implements IDrivingRestriction {
	

	@Override
	public boolean isValidPlate(String plate) {
		return getLastDigit(plate).chars().allMatch(x -> Character.isDigit(x));
	}
	
	/**
	 * Return the last digit of a plate
	 * @param plate
	 * @return last digit of the plate
	 */
	private String getLastDigit(String plate){
		return plate.substring(plate.length() -1 );
	}
	
	
	/**
	 * The day of the week according to the date
	 * @param date
	 * @return day of the week
	 */
	private DayOfWeek getDayOfWeek(String date){
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate.getDayOfWeek();		
		
	}
	
	@Override
	public boolean isDailyAllowedByPlate(String plate, String date){
		int lastDigit = Integer.parseInt(getLastDigit(plate));
		DayOfWeek day = getDayOfWeek(date); 
		switch (day) {
		case MONDAY:
			if(lastDigit == 1 || lastDigit == 2)
				return true;
			break;
		case TUESDAY:
			if(lastDigit == 3 || lastDigit == 4)
				return true;
			break;
		case WEDNESDAY:
			if(lastDigit == 5 || lastDigit == 6)
				return true;
			break;
		case THURSDAY:
			if(lastDigit == 7 || lastDigit == 8)
				return true;
			break;
		case FRIDAY:
			if(lastDigit == 9 || lastDigit == 0)
				return true;
			break;
		default:
			return false;
		}
		return false;
		
	}
	
	/**
	 * The time is in the interval of the morning restricted schedule
	 * @param time
	 * @return true or false
	 */
	public boolean isRestrictionSchedulesMorning(LocalTime time){
		if(time.isAfter(LocalTime.of(07, 00)) && time.isBefore(LocalTime.of(9,30))){
			return true;			
		}
		return false;
	}
	
	/**
	 * The time is in the interval of the afternoon restricted schedule
	 * @param time
	 * @return true or false
	 */
	public boolean isRestrictionSchedulesAfternnon(LocalTime time){
		if(time.isAfter(LocalTime.of(16, 00)) && time.isBefore(LocalTime.of(19,30))){
			return true;			
		}
		return false;
	}
	
	
	@Override
	public boolean isRestrictedSchedule(LocalTime time){
		if (isRestrictionSchedulesMorning(time) || isRestrictionSchedulesAfternnon(time)) {
			return true;
		}
		return false;
	}

	@Override
	public double fines(int repetitionNumber) {
		if(repetitionNumber == 1){
			return 56.25;
		} else if (repetitionNumber == 2) {
			return 93.75;
		} else if(repetitionNumber >= 3){
			return 187.50;
		}
		return 0;
	}	

}
