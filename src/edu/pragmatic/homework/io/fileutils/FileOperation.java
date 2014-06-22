package edu.pragmatic.homework.io.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
* A class representing file operations. The above mentioned methods can cut, copy and delete a file,
* checking for the eventual exception situations and throwing IO Exception where necessary.
*
*@author Evgeni Dimitrov
*/

public class FileOperation {

	public void copyFile(Path source, Path outputDirectory) throws IOException {

		Files.copy(source, Paths.get(outputDirectory.toString(), source
				.toFile().getName()));
	}

	public void copyFile(String source, String outputDirectory)
			throws IOException {
		copyFile(Paths.get(source), Paths.get(outputDirectory));
	}

	public void deleteFile(String sourceFile) throws IOException {
		deleteFile(Paths.get(sourceFile));
	}

	public void deleteFile(Path fileToDelete) throws IOException {
		if (fileToDelete == null)
			throw new IllegalArgumentException(
					"Provide the path to the file to delete");
		if (!fileToDelete.toFile().exists())
			throw new IllegalArgumentException("No file exists at "
					+ fileToDelete);

		Files.delete(fileToDelete);

	}

	public void cut(String pathToFile, String destinationDirectory)
			throws IOException {
		cut(Paths.get(pathToFile), Paths.get(destinationDirectory));
	}

	public void cut(Path source, Path outputDirectory) throws IOException {
		copyFile(source, outputDirectory);
		deleteFile(source);
	}

}
