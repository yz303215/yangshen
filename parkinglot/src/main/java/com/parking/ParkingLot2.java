package com.parking;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.entity.Car;
import com.entity.ParkingTicket;
import com.exception.HaveNoParkingSpaceException;
import com.exception.IllegalParkingTicketException;


/**
 *@TODO 停车场
 * @date  2019年2月19日 下午2:42:15
 * @author yangshen
 */
public  class ParkingLot2 implements Comparable<ParkingLot2>{
	
	/**
	 * 停车场号码
	 */
	private int sequence;
	
	/**
	 * 停车位数
	 */
	private int parkingSpaceNum = 2;
	
	/**
	 * 空置率
	 */
	private float rate;
	
	private Map<ParkingTicket, Car> parkRecords = new HashMap<ParkingTicket, Car>(2);
	
	
	/**
	 * @ TODO  停车,若无停车位,给出对应提示
	 * @param car
	 * @return
	 * @throws HaveNoParkingSpaceException
	 */
	public ParkingTicket parking(Car car) throws HaveNoParkingSpaceException {
		
		if (parkingSpaceNum < 1) {
			throw new HaveNoParkingSpaceException();
		}
		
		ParkingTicket ticket = new ParkingTicket();
		
		parkRecords.put(ticket, car);
		
		ticket.setParkingLotSequence(this.sequence);
		
		parkingSpaceNum--;
		
		this.calcRate();
		System.out.println("parkinglot：" + this.sequence+"号停车场-停车成功!目前空位数："+this.parkingSpaceNum+"空置率："+this.getRate()*100 +"%");
		
		return ticket;
	}

	
	/**根据停车票取车
	 * @param ticket
	 * @return
	 * @throws IllegalParkingTicketException 
	 */
	public Car getCar(ParkingTicket ticket) throws IllegalParkingTicketException {
		
		Car car = parkRecords.get(ticket);
		
		if (car == null) {
			throw new IllegalParkingTicketException();
		}
		
		parkRecords.remove(ticket);
		parkingSpaceNum ++ ;
		this.calcRate();
		System.out.println("parkinglot：" + this.sequence+"号停车场-取车成功!目前空位数："+this.parkingSpaceNum+"空置率："+this.rate*100 +"%");
		
		return car;
	}
	
	public int getParkingSpaceNum() {
		return parkingSpaceNum;
	}


	public void setParkingSpaceNum(int parkingSpaceNum) {
		this.parkingSpaceNum = parkingSpaceNum;
	}


	public Map<ParkingTicket, Car> getParkRecords() {
		return parkRecords;
	}


	public void setParkRecords(Map<ParkingTicket, Car> parkRecords) {
		this.parkRecords = parkRecords;
	}




	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
	}


	public ParkingLot2(int sequence) {
		super();
		this.sequence = sequence;
	}


	public ParkingLot2() {
	
	}



	@Override
	public String toString() {
		this.calcRate();
		return "ParkingLot" + sequence + "号停车场，空位:"
				+ parkingSpaceNum  +"空置率："+this.rate*100+ "%\n";
	}


	/**  重写排序，倒序排列 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ParkingLot2 o) {
		this.calcRate(o);
		this.calcRate();
		if (o.getRate()>this.getRate()) {
			return 1;
		}else if (o.getRate() < this.getRate()) {
			return -1;
		}
		return 0;
	}


	public ParkingLot2(int sequence, int parkingSpaceNum) {
		super();
		this.sequence = sequence;
		this.parkingSpaceNum = parkingSpaceNum;
		this.calcRate();
	}


	public float getRate() {
		return rate;
	}


	public void setRate(Float rate) {
		this.rate = rate;
	}
	
	
		/**
		 * 更新空置率
		 */
		private void  calcRate(){
				this.setRate(txfloat(this.getParkingSpaceNum(),   this.getParkingSpaceNum()+this.getParkRecords().size()) );
		}
		/**
		 * 更新空置率
		 */
		private float  calcRate(ParkingLot2 pLot2){
			pLot2.setRate(txfloat(pLot2.getParkingSpaceNum(),   pLot2.getParkingSpaceNum()+pLot2.getParkRecords().size()));;
			return pLot2.getRate();
	}
		
		/**
		 * 计算
		 * @param a
		 * @param b
		 * @return
		 */
		public static float txfloat(int a,int b) {
		 
		    DecimalFormat df=new DecimalFormat("0.000");//设置保留位数
	 
		    return Float.valueOf(df.format((float)a/b));
		   

		}
}
