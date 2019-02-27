package com;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.entity.Car;
import com.entity.ParkingTicket;
import com.exception.HaveNoParkingSpaceException;
import com.exception.IllegalParkingTicketException;
import com.parking.GraduateParkingBoy;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *@TODO 按顺序存取车
 * @date  2019年2月19日 下午3:52:50
 * @author yangshen
 */
public class GraduateParkingBoyTest {
	
	
	/**
	 * 存车
	 * @throws HaveNoParkingSpaceException
	 */
	@Test
	public void should_parking_by_sequence_of_parkinglot_when_graduate_parking_boy_given_one_more_parkinglots() throws HaveNoParkingSpaceException{
		
			GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
			
			List<ParkingTicket> tickets = new ArrayList<ParkingTicket>();
			
			for (int i = 0; i <5; i++) {
				Car car = new Car();
				assertThat(  tickets.add(  graduateParkingBoy.parkingBySequence(car)) );
			}
			
	}
	
	/**
	 * 取车
	 * @throws HaveNoParkingSpaceException 
	 * @throws IllegalParkingTicketException 
	 */
	@SuppressWarnings("unused")
	@Test
	public void should_get_car_success_when_parking_by_sequence_given_one_more_already_parkinged_prkinglots() throws HaveNoParkingSpaceException, IllegalParkingTicketException{
			
		GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
		
		List<ParkingTicket> tickets = new ArrayList<ParkingTicket>();
		
		for (int i = 0; i <5; i++) {
			Car car = new Car();
			assertThat(  tickets.add(  graduateParkingBoy.parkingBySequence(car)) );
		}
		
		if (tickets != null && tickets.size()>0) {
			for (ParkingTicket parkingTicket : tickets) {
				Car car = graduateParkingBoy.getCar(parkingTicket);
			}
		}
		
	}
	
	
}
