package com;

import org.junit.Test;

import com.entity.Car;
import com.exception.HaveNoParkingSpaceException;
import com.parking.ParkingLot2;
import com.parking.SuperParkingBoy;

/**
 *@TODO 作为一个超级停车小弟（Super Parking Boy），我能够将车停在空置率最高的那个停车场。
 * @date  2019年2月27日 上午10:16:32
 * @author yangshen
 */
public class SuperParkingBoyTest {

	
	/**
	 *  SuperParkingBoy
	 * @throws HaveNoParkingSpaceException 
	 */
	@Test
	public void should_parking_in_the_parkinglot_whitch_vacancy_rate_most_when_a_super_parking_boy_given_one_more_parkinglots() throws HaveNoParkingSpaceException{
		SuperParkingBoy superParkingBoy = new SuperParkingBoy();
		ParkingLot2[] parkingLots ={new ParkingLot2(1,1), new ParkingLot2(2,2),new ParkingLot2(3,3)};
		for (int i = 0; i <7; i++) {
			Car car = new Car();
			
			superParkingBoy.parking_in_the_parkinglot_whitch_vacancy_rate_most(car,parkingLots);
		}
	}

}
