package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CommandParser {
	
	/*
	 * Parking lot object
	 */
	private ParkingLot parkingLot;
	
	/**
	 * Constructor
	 */
	public CommandParser(){}
	
	/**
	 * Command 
	 * @param array of commands
	 * @return string output
	 */
	public String command(String[] commands){
		String result = "Command not found";
		try{
			if(commands[0].equalsIgnoreCase("create_parking_lot")){
				// Create parking lot
				if(commands.length == 2){
					int N = Integer.parseInt(commands[1]);
					parkingLot = new ParkingLot(N);
					result = "Created a parking lot with " + N + " slots";
				}
			}else if(commands[0].equalsIgnoreCase("park")){
				// Park a car
				if(parkingLot != null){
					if(commands.length == 3){
						Car c = new Car(commands[1], commands[2]);
						Integer slot = parkingLot.addCar(c);
						if(slot != null)
							result = "Allocated slot number: " + (slot+1);
						else
							result = "Sorry, parking lot is full";
					}
				}else
					result = "Parking lot is not created";
			}else if(commands[0].equalsIgnoreCase("leave")){
				// Car leave from parking slot
				if(parkingLot != null){
					if(commands.length == 2){
						int index = Integer.parseInt(commands[1]);
						Integer slot = parkingLot.removeCar(index-1);
						if(slot != null)
							result = "Slot number " + (slot+1) + " is free";
						else
							result = "Slot number " + index + " is not available or no car at this particular slot";
					}
				}else
					result = "Parking lot is not created";
			}else if(commands[0].equalsIgnoreCase("registration_numbers_for_cars_with_colour")){
				// Find registration number by car colour
				if(parkingLot != null){
					if(commands.length == 2){
						ArrayList<String> regNumbers = parkingLot.findRegNumberbyColour(commands[1]);
						int size = regNumbers.size();
						if(size > 0){
							result = "";
							for(int i = 0; i < size-1; ++i)
								result += regNumbers.get(i) + ", ";
							result += regNumbers.get(size-1);
						}else
							result = "Not found";
					}
				}else
					result = "Parking lot is not created";
			}else if(commands[0].equalsIgnoreCase("slot_number_for_registration_number")){
				// Find slot number by registration number
				if(parkingLot != null){
					if(commands.length == 2){
						ArrayList<Integer> slotNumbers = parkingLot.findSlotNumberbyRegNo(commands[1]);
						int size = slotNumbers.size();
						if(size > 0){
							result = "";
							for(int i = 0; i < size-1; ++i)
								result += slotNumbers.get(i) + ", ";
							result += slotNumbers.get(size-1);
						}else
							result = "Not found";
					}
				}else
					result = "Parking lot is not created";
			}else if(commands[0].equalsIgnoreCase("slot_numbers_for_cars_with_colour")){
				// Find slot number by car's colour
				if(parkingLot != null){
					if(commands.length == 2){
						ArrayList<Integer> slotNumbers = parkingLot.findSlotNumberbyColour(commands[1]);
						int size = slotNumbers.size();
						if(size > 0){
							result = "";
							for(int i = 0; i < size-1; ++i)
								result += slotNumbers.get(i) + ", ";
							result += slotNumbers.get(size-1);
						}else
							result = "Not found";
					}
				}else
					result = "Parking lot is not created";
			}else if(commands[0].equalsIgnoreCase("status")){
				// Display status
				if(parkingLot != null)
					result = parkingLot.status();
				else
					result = "Parking lot is not created";
			}else if(commands[0].equalsIgnoreCase("exit")){
				// Exit program
				result = null;
			}
		}catch(Exception e){
			result = "Command error";
		}
		return result;
	}
	
	/**
	 * Command by file which read the command line by line from input file
	 * @param inputFilePath
	 * @return output string
	 * @throws IOException
	 */
	public String commandByFile(String inputFilePath) throws IOException{
		String result = "";
		FileReader fr = new FileReader(inputFilePath);
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		while((currentLine = br.readLine()) != null){
			String[] commands = currentLine.split("\\s+");
			result += command(commands) + "\n";
		}
		br.close();
		fr.close();
		return result;
	}
	
	/**
	 * Save output string to file
	 * @param outputFilePath
	 * @param output
	 * @throws IOException
	 */
	public void saveOutputToFile(String outputFilePath, String output) throws IOException{
		PrintWriter writer = new PrintWriter(outputFilePath, "UTF-8");
	    writer.print(output);
	    writer.close();
	}

}
