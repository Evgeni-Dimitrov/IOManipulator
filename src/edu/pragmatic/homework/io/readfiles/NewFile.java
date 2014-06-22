package edu.pragmatic.homework.io.readfiles;

import java.io.File;
import java.util.Scanner;

/**
 * A class which checks whether the file denoted by this pathname exists.
 * 
 * author Evgeni Dimitrov
 */

public class NewFile {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			String fileName = console.nextLine();
			File file = new File(fileName);
			System.out.println("File at " + fileName + " "
					+ (file.exists() ? "exists" : "don't exist"));
		}
	}
}
