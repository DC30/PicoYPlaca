package test;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import picoplaca.MainPredictor;

public class PredictorTest {
	
	private MainPredictor predictor;
	
	@Before
	public void setUp(){
		predictor = new MainPredictor();
	}

	@Test
	public void notAllowedOnRoad(){
		String result = predictor.allowedOnRoad("ABC0196", "13-09-2017", LocalTime.parse("19:10"));
		Assert.assertEquals("Car is not allowed on road is Pico y Placa", result);
	}
	
	@Test
	public void allowedOnRoad(){
		String result = predictor.allowedOnRoad("ABC0123", "13-09-2017", LocalTime.parse("19:10"));
		Assert.assertEquals("Car can be on road", result);
	}
	
	@Test
	public void wrongPlate(){
		String result = predictor.allowedOnRoad("ABC0196y", "13-09-2017", LocalTime.parse("19:10"));
		Assert.assertEquals("There is a problem with the plate", result);
	}
}
