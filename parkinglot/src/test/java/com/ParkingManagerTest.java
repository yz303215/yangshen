package com;

import org.junit.Test;

import com.entity.Car;
import com.exception.HaveNoParkingSpaceException;
import com.parking.ParkingLot;
import com.parking.ParkingManager;

/**
 *@TODO  作为停车场的经理（Parking Manager），我要管理多个停车仔，让他们停车，同时也可以自己停车。
 * @date  2019年2月27日 下午2:30:27
 * @author yangshen
 */
public class ParkingManagerTest {
	
	
	@Test
	public void should_parking_succ_when_command_the_parkingboy_parking_car_given_parkinglot_and_parkingboy() throws HaveNoParkingSpaceException{
		
		ParkingManager parkingManager = new ParkingManager();
		
		parkingManager.command_the_graduate_parkingboy_parking_car(new Car());
		
		parkingManager.command_the_smart_parkingboy_parking_car(new Car());
		
		parkingManager.command_the_super_parkingboy_parking_car(new Car());
	}
	
	
	@Test
	public void shold_parking_succ_when_parking_by_himself_given_parkingmanager() throws HaveNoParkingSpaceException{
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.parking(new Car());
	}
}
