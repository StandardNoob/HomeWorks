package com.learnit.operations.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Console text editor
		TextEditor textEditor = new TextEditor(new File("src\\com\\learnit\\operations\\io\\textEditor.txt"));
		textEditor.start();
		textEditor.printToConsole();

		// Console application that return value by key from config file:
		ConfigReader configReader = new ConfigReader(Paths.get("src\\com\\learnit\\operations\\io\\config.txt"));
		System.out.println(configReader.getValueFromConfigMap(configReader.getConfig(), "database.passwor"));

		// Get the number of files with the extension
		FilesCounter filesCounter = new FilesCounter();
		Path path = Paths.get(".");
		String extension = ".java";
		System.out.println(filesCounter.getNumberOfFilesWithExtension(path, extension));
	}

}
