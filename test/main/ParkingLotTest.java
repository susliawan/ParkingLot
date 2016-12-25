package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
	
	private ParkingLot parkingLot;
	
	@Before
	public void runBeforeEachTest(){
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
	public void testFindRegNumberByColour(){
		Car c1 = new Car("10", "Black");
		Car c2 = new Car("11", "White");
		Car c3 = new Car("12", "Blue");
		Car c4 = new Car("13", "White");
		Car c5 = new Car("14", "White");
		
		parkingLot.addCar(c1);
		parkingLot.addCar(c2);
		parkingLot.addCar(c3);
		parkingLot.addCar(c4);
		parkingLot.addCar(c5);
		
		ArrayList<String> indexes = parkingLot.findRegNumberbyColour("white");
		assertEquals("11", indexes.get(0));
		indexes = parkingLot.findRegNumberbyColour("yellow");
		assertEquals(0, indexes.size());
	}
	
	@Test
	public void testFindSlotNumberbyRegNo(){
		Car c1 = new Car("10", "Black");
		Car c2 = new Car("11", "White");
		Car c3 = new Car("12", "Blue");
		Car c4 = new Car("13", "Orange");
		Car c5 = new Car("14", "Purple");

		parkingLot.addCar(c1);
		parkingLot.addCar(c2);
		parkingLot.addCar(c3);
		parkingLot.addCar(c4);
		parkingLot.addCar(c5);
		
		ArrayList<Integer> indexes = parkingLot.findSlotNumberbyRegNo("12");
		assertEquals((Integer)3, indexes.get(0));
		indexes = parkingLot.findSlotNumberbyRegNo("15");
		assertEquals(0, indexes.size());
	}
	
	@Test
	public void testFindSlotNumberbyColour(){
		Car c1 = new Car("10", "Black");
		Car c2 = new Car("11", "White");
		Car c3 = new Car("12", "Blue");
		Car c4 = new Car("13", "Blue");
		Car c5 = new Car("14", "Purple");

		parkingLot.addCar(c1);
		parkingLot.addCar(c2);
		parkingLot.addCar(c3);
		parkingLot.addCar(c4);
		parkingLot.addCar(c5);
		
		ArrayList<Integer> indexes = parkingLot.findSlotNumberbyColour("blue");
		assertEquals((Integer)3, indexes.get(0));
		assertEquals((Integer)4, indexes.get(1));
		indexes = parkingLot.findSlotNumberbyColour("Pink");
		assertEquals(0, indexes.size());
	}
	
	@Test
	public void testRemoveCar(){
		Car c1 = new Car("10", "Black");
		Car c2 = new Car("11", "White");
		Car c3 = new Car("12", "Blue");
		Car c4 = new Car("13", "Orange");
		Car c5 = new Car("14", "Purple");

		parkingLot.addCar(c1);
		parkingLot.addCar(c2);
		parkingLot.addCar(c3);
		parkingLot.addCar(c4);
		parkingLot.addCar(c5);
		
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
