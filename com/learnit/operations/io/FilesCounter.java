package com.learnit.operations.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilesCounter {
	private static ArrayList<String> listOfAllFiles = new ArrayList<String>();

	public long getNumberOfFilesWithExtension(Path pathToStartSearch, String extension) throws IOException {
		long numOfFilesWithExtension = 0;
		getNumOfFiles(new File(pathToStartSearch.toString()));
		for (String list : listOfAllFiles) {
			if (list.endsWith(extension)) {
				numOfFilesWithExtension++;
			}
		}
		return numOfFilesWithExtension;
	}

	public void getNumOfFiles(File file) {
		File[] listofFiles = file.listFiles();
		for (File entry : listofFiles) {
			if (entry.isDirectory()) {
				getNumOfFiles(entry);
				continue;
			}
			listOfAllFiles.add(entry.getName());
		}
	}
}
