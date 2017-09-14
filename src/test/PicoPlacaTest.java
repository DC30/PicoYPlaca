package test;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import picoplaca.PicoYPlaca;

public class PicoPlacaTest {
	
	private PicoYPlaca picoPlaca;
	
	@Before
	public void setUp(){
		picoPlaca = new PicoYPlaca();
	}
	
//	@Test
//	public void getLastDigit(){
//		String result = controller.getLastDigit("ABC-123");
//		Assert.assertEquals("3", result);
//	}
	
	@Test
	public void validPlate(){
		Assert.assertTrue(picoPlaca.isValidPlate("ABC-123"));
	}
	
	@Test
	public void NotvalidPlate(){
		Assert.assertFalse(picoPlaca.isValidPlate("ABC-123L"));
	}
	
	
	@Test
	public void DailyAllowedByPlate(){
		Assert.assertTrue(picoPlaca.isDailyAllowedByPlate("ABC0124", "12-09-2017"));
	}
	
	@Test
	public void restrictionMorning(){
		Assert.assertTrue(picoPlaca.isRestrictionSchedulesMorning(LocalTime.parse("09:20")));
//		Assert.assertFalse(controller.isRestrictionSchedulesMorning(LocalTime.parse("08:30")));
	}
	
	@Test
	public void restrictionAfternoon(){
		Assert.assertTrue(picoPlaca.isRestrictionSchedulesAfternnon(LocalTime.parse("18:00")));
	}
	
	@Test
	public void restrictedSchedule(){
		Assert.assertTrue(picoPlaca.isRestrictedSchedule(LocalTime.parse("17:51")));
	}

}
