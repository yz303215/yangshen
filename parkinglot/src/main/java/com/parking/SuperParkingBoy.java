package com.parking;

import java.util.Arrays;

import com.entity.Car;
import com.exception.HaveNoParkingSpaceException;

/**
 *@TODO 4. 作为一个超级停车小弟（Super Parking Boy），我能够将车停在空置率最高的那个停车场。
 * @date  2019年2月27日 上午10:18:53
 * @author yangshen
 */
public class SuperParkingBoy {
	/**
	 * 空位数
	 */
	private int parkingSpaceNum = 6;
	/**
	 * 空置率最高的优先停车
	 * @param car
	 * @throws HaveNoParkingSpaceException 
	 */
	public void parking_in_the_parkinglot_whitch_vacancy_rate_most(Car car,ParkingLot2[] parkingLots) throws HaveNoParkingSpaceException {
		if (parkingSpaceNum<1) {
			throw new HaveNoParkingSpaceException();
		}
	//	ParkingLot2[] parkingLots ={new ParkingLot2(1,1), new ParkingLot2(2,2),new ParkingLot2(3,3)};
		Arrays.sort(parkingLots);
		System.out.println("目前停车场情况：");
		System.out.println(Arrays.toString(parkingLots));
		parkingLots[0].parking(car);
		parkingSpaceNum--;
		
	}

}
