package edu.pragmatic.homework.io.writetofile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
* This class represents a method which prints the user input from the console to a file.
*   
*@author Evgeni Dimitrov
*/

public class WriteToFile {

	public void printFromConsoleToFile(String filePath) throws IOException {
		if (filePath == null || filePath.isEmpty())
			throw new IllegalArgumentException("File path must be provided");

		File outputFile = Paths.get(filePath).toFile();
		if (!outputFile.exists())
			throw new FileNotFoundException(filePath
					+ " is not a correct file path");

		try (FileWriter fw = new FileWriter(outputFile);
				Scanner console = new Scanner(System.in)) {
			String consoleLine = console.nextLine();
			fw.write(consoleLine + "\n");
		}
	}

}
