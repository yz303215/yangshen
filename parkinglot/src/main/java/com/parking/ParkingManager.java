package com.parking;

import com.entity.Car;
import com.exception.HaveNoParkingSpaceException;

/**
 *@TODO 作为停车场的经理（Parking Manager），我要管理多个停车仔，让他们停车，同时也可以自己停车。
 * @date  2019年2月27日 下午2:47:01
 * @author yangshen
 */
public class ParkingManager {

	
	/**
	 * Graduate Parking Boy Parking Car
	 * @param car 
	 * @throws HaveNoParkingSpaceException 
	 */
	public void command_the_graduate_parkingboy_parking_car(Car car) throws HaveNoParkingSpaceException {
		ParkingLot parkingLot=  new ParkingLot();
		parkingLot.parking(car);
	}
	
	/**
	 * Smart Parking Boy Parking Car
	 * @param car 
	 * @throws HaveNoParkingSpaceException 
	 */
	public void command_the_smart_parkingboy_parking_car(Car car) throws HaveNoParkingSpaceException {
		SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
		smartParkingBoy.pakingInMostSpaceLot(car);
		
		
	}

	/**
	 * Super Parking Boy Parking Car
	 * @throws HaveNoParkingSpaceException 
	 */
	public void command_the_super_parkingboy_parking_car(Car car) throws HaveNoParkingSpaceException {
		SuperParkingBoy superParkingBoy = new SuperParkingBoy();
		ParkingLot2[] parkingLots ={new ParkingLot2(1,1), new ParkingLot2(2,2),new ParkingLot2(3,3)};
			superParkingBoy.parking_in_the_parkinglot_whitch_vacancy_rate_most(car,parkingLots);
		
	}

	

}
