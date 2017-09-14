package picoplaca;

import java.time.LocalTime;
/**
 * 
 * @author Diana
 *
 */
public interface IDrivingRestriction {

	/**
	 * Valid if the last letter of the plate is a digit
	 * @param plate
	 * @return true or false
	 */
	boolean isValidPlate(String plate);
	
	/**
	 * The car is allowed by plate according to the day of the week  
	 * @param plate
	 * @param date
	 * @return true or false
	 */

	boolean isDailyAllowedByPlate(String plate, String date);

	/**
	 * The time is in the interval of the restricted schedule
	 * @param time
	 * @return true or false
	 */
	boolean isRestrictedSchedule(LocalTime time);
	
	/**
	 * Value of the fines according to the number of repetition
	 * @param repetitionNumber
	 * @return
	 */
	double fines(int repetitionNumber);

}