package com;


import org.junit.Test;

import com.entity.Car;
import com.exception.HaveNoParkingSpaceException;
import com.parking.SmartParkingBoy;

/**
 *@TODO 作为一个聪明的停车小弟（Smart Parking Boy），我能够将车停在空车位最多的那个停车场。
 * @date  2019年2月21日 上午11:38:47
 * @author yangshen
 */
public class SmartParkingBoyTest {
		
	/**
	 *  Smart Parking Boy 
	 * @throws HaveNoParkingSpaceException 
	 */
	@Test
	public void should_parking_in_the_parkinglot_whitch_space_most_when_a_smart_parking_boy_given_one_more_parkinglots() throws HaveNoParkingSpaceException{
		SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
		
		Car car = new Car();
		
		smartParkingBoy.pakingInMostSpaceLot(car);
	}
}
