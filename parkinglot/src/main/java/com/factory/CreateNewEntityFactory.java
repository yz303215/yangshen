package com.factory;

import com.entity.Car;
import com.entity.ParkingTicket;
import com.parking.ParkingLot;

/**
 *@TODO 简单工厂
 * @date  2019年2月19日 下午3:40:55
 * @author yangshen
 */
public class CreateNewEntityFactory {
	
	public static ParkingLot createParkingLot(){
		return new ParkingLot();
	}
	
	public static ParkingTicket createParkingTicket(){
		return new ParkingTicket();
	}
	
	public static Car createCar(){
		return new Car();
	}
}
