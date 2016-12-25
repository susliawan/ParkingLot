package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CommandParser parser = new CommandParser();
		String inFilePath = "/Users/Susliawan/Desktop/input.txt";
		String outFilePath = "/Users/Susliawan/Desktop/output.txt";
		try {
			String output = parser.commandByFile(inFilePath);
			parser.saveOutputToFile(outFilePath, output);
			System.out.println(output);
		} catch (IOException e) {
			System.out.println("File reading error");
		}
		
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while(!exit){
			System.out.println("Input:");
			String commandStr = sc.nextLine();
			String[] commands = commandStr.split("\\s+");
			String result = parser.command(commands);
			if(result != null)
				System.out.println("Output:\n" + result);
			else
				exit = true;	
		}
		sc.close();
	}
}
