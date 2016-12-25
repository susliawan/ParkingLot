package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandParserTest {

	private CommandParser parser;
	
	@Before
	public void runBeforeEachTest(){
		parser = new CommandParser();
	}
	
	@Test
	public void testCommand(){
		// Test random command
		String[] commands = {"asdfgh", "sdfs", "dfsfs"};
		String output = parser.command(commands);
		assertEquals("Command not found", output);
		
		// Test add park berfore create parking lot
		String[] commands1 = {"park", "KA-001", "white"};
		output = parser.command(commands1);
		assertEquals("Parking lot is not created", output);
		
		// Test create parking lot with N is not integer
		String[] commands2 = {"create_parking_lot", "Test"};
		output = parser.command(commands2);
		assertEquals("Command error", output);
		
		// Test create parking lot with N integer
		String[] commands3 = {"create_parking_lot", "3"};
		output = parser.command(commands3);
		assertEquals("Created a parking lot with 3 slots", output);
		
		// Test park
		String[] commands4 = {"park", "T-002", "White"};
		output = parser.command(commands4);

		assertEquals("Allocated slot number: 1", output);
		
		// Test park full
		String[] commands5 = {"park", "T-003", "Black"};
		output = parser.command(commands5);
		String[] commands6 = {"park", "T-004", "White"};
		output = parser.command(commands6);
		String[] commands7 = {"park", "T-005", "White"};
		output = parser.command(commands7);
		assertEquals("Sorry, parking lot is full", output);
		
		// Test find reg no by car colour
		String[] commands8 = {"registration_numbers_for_cars_with_colour", "white"};
		output = parser.command(commands8);
		assertEquals("T-002, T-004", output);
		
		// Test find slot number by reg no
		String[] commands9 = {"slot_number_for_registration_number", "T-004"};
		output = parser.command(commands9);
		assertEquals("3", output);
		
		// Test find slot number by car colour
		String[] commands10 = {"slot_numbers_for_cars_with_colour", "white"};
		output = parser.command(commands10);
		assertEquals("1, 3", output);
		
		// Test leave
		String[] commands11 = {"leave", "2"};
		output = parser.command(commands11);
		assertEquals("Slot number 2 is free", output);
		
		// Test status
		String[] commands12 = {"status"};
		output = parser.command(commands12);
		assertEquals("Slot No.\t Reg No.\t Colour \n"
				+ "1\t\t T-002\t\t White\n" + "3\t\t T-004\t\t White\n", output);	
	}

}
