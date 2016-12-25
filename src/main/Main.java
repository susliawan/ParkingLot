package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CommandParser parser = new CommandParser();
		if(args.length == 2){
			// Command by file input and output
			String inFilePath = args[0];
			String outFilePath = args[1];
			try {
				String output = parser.commandByFile(inFilePath);
				parser.saveOutputToFile(outFilePath, output);
				System.out.println(output);
				System.out.println("Sucessfully saved the outputs to " + outFilePath);
			} catch (IOException e) {
				System.out.println("File processing error");
			}
		}else if(args.length == 0){
			// Command in interactive way based on user input
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
		}else
			System.out.println("Parameters are incomplete");
	}
}
