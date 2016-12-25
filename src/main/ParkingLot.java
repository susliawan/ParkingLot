package main;
import java.util.ArrayList;
import java.util.Collections;

public class ParkingLot {
	
	/*
	 * N contains number of parking lot space
	 */
	private int N;
	
	/*
	 * lots contains list of cars in parking lot
	 */
	private ArrayList<Car> lots;
	
	/*
	 * availableSlots contains index list of available parking slots
	 */
	private ArrayList<Integer> availableSlots;
	
	/**
	 * Constructor
	 * @param Integer _N
	 */
	public ParkingLot(int _N){
		this.N = _N;
		this.lots = new ArrayList<>(N);
		this.availableSlots = new ArrayList<>(N);
		// Initialize list available lots index and car lots 
		for(int i = 0; i < N; ++i){
			this.availableSlots.add(i);
			this.lots.add(null);
		}
	}
	
	/**
	 * Add car
	 * @param Car c
	 * @return Integer index if car successfully added to lots
	 * 		   Null if parking lot is already full
	 */
	public Integer addCar(Car c){
		if(!availableSlots.isEmpty()){
			Integer index = availableSlots.remove(0);
			lots.set(index, c);
			return index;
		}else
			return null;
	}
	
	/**
	 * Remove car
	 * @param Integer index
	 * @return Integer slot's index if car successfully removed from lots
	 * 		   Null if there is no car at the particular lot or index greater than N
	 */
	public Integer removeCar(int index){
		if(index < N && index >= 0){
			if(!availableSlots.contains(index)){
				lots.set(index, null);
				availableSlots.add(index);
				Collections.sort(availableSlots);
				return index;
			}else
				return null;
		}else
			return null;
	}
	
	/**
	 * Status
	 * @return String of parking lot's status 
	 */
	public String status(){
		String status = "Slot No.\t Reg No.\t Colour \n";
		for(int i = 0; i < N; ++i){
			Car c = lots.get(i);
			if(c != null)
				status += (i+1) + "\t\t " + c.registrationNo() + "\t\t " + c.colour() + "\n";
		}
		return status;
	}
	
	/**
	 * Find Slot Number by Reg No
	 * @param regNo
	 * @return list of slots number
	 */
	public ArrayList<Integer> findSlotNumberbyRegNo(String regNo){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < lots.size(); ++i){
			Car c = lots.get(i);
			String carRegNo = c.registrationNo().replaceAll("-", "");
			regNo = regNo.replaceAll("-", "");
			if(c != null && carRegNo.equalsIgnoreCase(regNo))
				result.add(i+1);
		}
		return result;
	}
	
	/**
	 * Find Slot Number By Colour
	 * @param colour
	 * @return list of slots number
	 */
	public ArrayList<Integer> findSlotNumberbyColour(String colour){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < lots.size(); ++i){
			Car c = lots.get(i);
			if(c != null && c.colour().equalsIgnoreCase(colour))
				result.add(i+1);
		}
		return result;
	}
	
	/**
	 * Find Reg Number By Colour
	 * @param colour
	 * @return list of reg number
	 */
	public ArrayList<String> findRegNumberbyColour(String colour){
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < lots.size(); ++i){
			Car c = lots.get(i);
			if(c != null && c.colour().equalsIgnoreCase(colour))
				result.add(c.registrationNo());
		}
		return result;
	}
}
