package com.parking;

import java.util.Arrays;



import com.entity.Car;
import com.exception.HaveNoParkingSpaceException;

/**
 *@TODO 3. 作为一个聪明的停车小弟（Smart Parking Boy），我能够将车停在空车位最多的那个停车场。
 * @date  2019年2月26日 上午9:31:47
 * @author yangshen
 */
public class SmartParkingBoy  {
	/**
	 * 空位数
	 */
	private int parkingSpaceNum = 6;
	

	/** 停车至空位最多的停车场
	 * @param car
	 * @throws HaveNoParkingSpaceException 
	 */
	public void pakingInMostSpaceLot(Car car) throws HaveNoParkingSpaceException {
		
		if (parkingSpaceNum<1) {
			throw new HaveNoParkingSpaceException();
		}
		ParkingLot[] parkingLots ={new ParkingLot(1,1), new ParkingLot(2,2),new ParkingLot(3,3)};
		Arrays.sort(parkingLots);
		System.out.println("目前停车场空位数：");
		System.out.println(Arrays.toString(parkingLots));
		parkingLots[0].parking(car);
		parkingSpaceNum--;
	}

}
