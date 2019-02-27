package com;

import org.junit.Test;

import com.entity.Car;
import com.entity.ParkingTicket;
import com.exception.HaveNoParkingSpaceException;
import com.exception.IllegalParkingTicketException;
import com.parking.ParkingLot;

import static org.assertj.core.api.Assertions.assertThat;



/**
 * 停车场测试用例
 * @author yangshen
 *
 */
public class ParkingLotTest {
	
	/**
	 * 停车
	 * @throws HaveNoParkingSpaceException
	 */
	@Test
	public void should_success_when_parking_given_the_car_and_space_parkinglot() throws HaveNoParkingSpaceException{
		
		ParkingLot freeParkingLot = new ParkingLot(); //停车场
		
		Car car = new Car();  // 车
		
		assertThat(freeParkingLot.parking( car ));
		
	}
		/**
		 * 1. 作为一个停车场，能够存车、取车。
		 * @throws HaveNoParkingSpaceException 
		 * @throws IllegalParkingTicketException 
		 */
		@Test
		public void should_success_when_parking_or_get_the_car_given_the_car_and_a_free_space() throws HaveNoParkingSpaceException, IllegalParkingTicketException  {
			
				ParkingLot freeParkingLot = new ParkingLot(); //停车场
				
				Car car = new Car();  // 车
				
				ParkingTicket ticket = freeParkingLot.parking( car ); //停车
				
				assertThat(freeParkingLot.getCar( ticket )).isEqualTo(car); //取车
				
		}
}
