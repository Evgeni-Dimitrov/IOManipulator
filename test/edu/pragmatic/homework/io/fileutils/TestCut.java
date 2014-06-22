package edu.pragmatic.homework.io.fileutils;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

/**
* A Test Class which checks the proper functionality of the method cut() in the Class FileOperation.
*   
*@author Evgeni Dimitrov
*/

public class TestCut {

	@Test
	public void testCut() throws IOException {
		FileOperation fileOperation = new FileOperation();
		fileOperation
				.cut("resources/source/sourcefile.txt", "resources/target");
		Assert.assertTrue(new File("resources/target/sourcefile.txt").exists());
	}

}
