package edu.pragmatic.homework.io.wordcounter;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.junit.Test;



import junit.framework.Assert;

/**
* A Test Class which checks the proper functionality of the methods in class WordCounter.
*   
*@author Evgeni Dimitrov
*/

public class TestWordCounter {

	@Test
	public void testRetrivalOfTextFiles() {
		WordCounter counter = new WordCounter();
		List<File> textFiles = counter
				.getTextFilesFromDir("resources/dir_to_traverse");
		Assert.assertNotNull(textFiles);
		Assert.assertEquals(8, textFiles.size());
	}

	@Test
	public void testCountWordsFromFile() {
		WordCounter counter = new WordCounter();
		File targetFile = Paths.get("resources/sample.txt").toFile();
		Map<String, Integer> fileWordCount = counter
				.countWordsForAFile(targetFile);
		Assert.assertNotNull(fileWordCount);
		Assert.assertFalse(fileWordCount.isEmpty());
	}

	@Test
	public void testCountAllWords() {
		WordCounter counter = new WordCounter();
		File targetFile = Paths.get("resources/sample.txt").toFile();
		Map<String, Integer> referenceWordCount = counter
				.countWordsForAFile(targetFile);

		List<File> textFiles = counter
				.getTextFilesFromDir("resources/dir_to_traverse");
		int textFilesCount = textFiles.size();
		Map<String, Integer> wordCounter = counter.countWords(textFiles);

		for (String word : wordCounter.keySet()) {
			int calculatedWordCount = wordCounter.get(word);
			int singleFileWordCount = referenceWordCount.get(word);
			Assert.assertEquals(singleFileWordCount * textFilesCount,
					calculatedWordCount);
		}
	}
}
