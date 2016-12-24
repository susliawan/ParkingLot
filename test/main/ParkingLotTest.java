package main;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ParkingLotTest {
	
	private static ParkingLot parkingLot;
	
	@BeforeClass
	public static void runBeforeClass(){
		parkingLot = new ParkingLot(5);
	}
	
	@Test
	public void testAddCar() {
		Car c1 = new Car("10", "Black");
		Car c2 = new Car("11", "White");
		Car c3 = new Car("12", "Blue");
		Car c4 = new Car("13", "Orange");
		Car c5 = new Car("14", "Purple");
		Car c6 = new Car("15", "Pink");
		
		Integer index = parkingLot.addCar(c1);
		assertEquals((Integer)0, index);
		index = parkingLot.addCar(c2);
		assertEquals((Integer)1, index);
		index = parkingLot.addCar(c3);
		assertEquals((Integer)2, index);
		index = parkingLot.addCar(c4);
		assertEquals((Integer)3, index);
		index = parkingLot.addCar(c5);
		assertEquals((Integer)4, index);
		index = parkingLot.addCar(c6);
		assertEquals(null, index);
		System.out.println("testAddCar");
		System.out.println(parkingLot.status());
	}
	
	@Test
	public void testRemoveCar(){
		Integer index = parkingLot.removeCar(7);
		assertEquals(null, index);
		index = parkingLot.removeCar(3);
		assertEquals((Integer)3, index);
		index = parkingLot.removeCar(3);
		assertEquals(null, index);
		index = parkingLot.removeCar(1);
		assertEquals((Integer)1, index);
		System.out.println("testRemoveCar");
		System.out.println(parkingLot.status());
		index = parkingLot.removeCar(0);
		assertEquals((Integer)0, index);
		index = parkingLot.removeCar(2);
		assertEquals((Integer)2, index);
		index = parkingLot.removeCar(4);
		assertEquals((Integer)4, index);
		System.out.println("testRemoveCar");
		System.out.println(parkingLot.status());
		assertEquals((Integer)4, index);
		
		Car c6 = new Car("15", "Pink");
		index = parkingLot.addCar(c6);
		assertEquals((Integer)0, index);
		System.out.println("testAddCar");
		System.out.println(parkingLot.status());
	}

}
