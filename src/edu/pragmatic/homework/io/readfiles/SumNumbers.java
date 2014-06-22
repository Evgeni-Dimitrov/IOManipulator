package edu.pragmatic.homework.io.readfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* This class represents multiple IO functionalities. The available methods can check and get the numbers 
* from a file, sum them, print them to the console, copy them in another file or at the 
* end of it, checking for the eventual exception situations and throwing IO Exception where 
* necessary.
*
*@author Evgeni Dimitrov
*/

public class SumNumbers {

	public List<Integer> getNumbersFromFile(String filePath)
			throws FileNotFoundException {
		if (filePath == null || filePath.isEmpty()) {
			throw new IllegalArgumentException("Specify filepath");
		}

		Path path = Paths.get(filePath);
		File file = path.toFile();
		List<Integer> numbers = new ArrayList<>();
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {
				String rawNumber = sc.next();
				if (isNumber(rawNumber)) {
					numbers.add(Integer.valueOf(rawNumber));
				}
			}
		}

		return numbers;
	}

	private boolean isNumber(String number) {
		char[] idividualLetters = number.toCharArray();
		for (char c : idividualLetters) {
			if (!Character.isDigit(c))
				return false;
		}

		return true;
	}

	public long sum(List<Integer> numbers) {
		long result = 0L;
		for (Integer num : numbers) {
			result += num;
		}
		return result;
	}

	public void printToConsole(long sumOfallIntegers) {
		System.out.println(sumOfallIntegers);
	}

	public void printToFile(String destinationFileName, Long sum)
			throws IOException {
		if (destinationFileName == null || destinationFileName.isEmpty()) {
			throw new IllegalArgumentException("Specify destinationFileName");
		}
		if (sum == null)
			throw new IllegalArgumentException(
					"The sum arg can't be null. What should we print out!");

		Path path = Paths.get(destinationFileName);
		File file = path.toFile();
		try (FileWriter fw = new FileWriter(file)) {
			fw.write(String.valueOf(sum));
		}
	}

	public void printToEndOfFile(String fileName, Long sum) throws IOException {
		if (fileName == null || fileName.isEmpty()) {
			throw new IllegalArgumentException("Specify destinationFileName");
		}
		if (sum == null)
			throw new IllegalArgumentException(
					"The sum arg can't be null. What should we print out!");
		File file = Paths.get(fileName).toFile();

		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			raf.seek(file.length());
			raf.writeBytes(" ");
			raf.writeBytes(String.valueOf(sum));
		}
	}

}
