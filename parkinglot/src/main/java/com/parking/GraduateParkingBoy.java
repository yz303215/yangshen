package com.parking;

import java.util.HashMap;
import java.util.Map;

import com.entity.Car;
import com.entity.ParkingTicket;
import com.exception.HaveNoParkingSpaceException;
import com.exception.IllegalParkingTicketException;


/**
 *@TODO 作为一个初入职场的停车小弟（Graduate Parking Boy），我能够将车按顺序停放到多个停车场，并可以取出。
 * @date  2019年2月19日 下午4:38:43
 * @author yangshen
 */
public class GraduateParkingBoy {
	
	/**
	 * 空位数
	 */
	private int parkingSpaceNum = 6;
	
	/**
	 * 已停车，记录
	 */
	private Map<ParkingTicket, Car> alreadyParkingMap = new HashMap<ParkingTicket, Car>();
	
	private static  Map<Integer, ParkingLot> parkinglotsMap = new HashMap<Integer, ParkingLot>();
		

		static{
			parkinglotsMap.put(1, new ParkingLot(1));
			parkinglotsMap.put(2, new ParkingLot(2));
			parkinglotsMap.put(3, new ParkingLot(3));
		}
	
	/**
	 * 按顺序停车
	 * @param car
	 * @return 
	 * @throws HaveNoParkingSpaceException 
	 */
	public ParkingTicket parkingBySequence(Car car) throws HaveNoParkingSpaceException {
		
		if (parkingSpaceNum<1) {
			throw new HaveNoParkingSpaceException();
		}
		
		ParkingTicket ticket = new ParkingTicket();
		
		for (Integer key : parkinglotsMap.keySet()) {
			
			ParkingLot parkingLot = parkinglotsMap.get(key);
			if (parkingLot.getParkingSpaceNum()>0) {
				ticket = parkingLot.parking(car);
				parkingSpaceNum--;
				alreadyParkingMap.put(ticket, car);
				break;
			}
		}
		return ticket;
	}

	
	
	/**
	 * 取车
	 * @param parkingTicket
	 * @return
	 * @throws IllegalParkingTicketException
	 */
	public Car getCar(ParkingTicket parkingTicket) throws IllegalParkingTicketException {
		
		if (alreadyParkingMap.size()<1 || alreadyParkingMap.get(parkingTicket) == null) {
			throw new IllegalParkingTicketException();
		}
		
		int parkingLotSequence = parkingTicket.getParkingLotSequence();
		System.out.println("GraduateParkingBoy：当前停车票对应车辆停于["+parkingLotSequence+"]号停车场……");
		
		Car car = parkinglotsMap.get(parkingLotSequence).getCar(parkingTicket);
		alreadyParkingMap.remove(parkingTicket);
		parkingSpaceNum ++;
		
		return car;
	}
	
	
	public Map<Integer, ParkingLot> getParkinglotsMap() {
		return parkinglotsMap;
	}

	public int getParkingSpaceNum() {
		return parkingSpaceNum;
	}

	public void setParkingSpaceNum(int parkingSpaceNum) {
		this.parkingSpaceNum = parkingSpaceNum;
	}



	public Map<ParkingTicket, Car> getAlreadyParkingMap() {
		return alreadyParkingMap;
	}

	public void setAlreadyParkingMap(Map<ParkingTicket, Car> alreadyParkingMap) {
		this.alreadyParkingMap = alreadyParkingMap;
	}

	
}
