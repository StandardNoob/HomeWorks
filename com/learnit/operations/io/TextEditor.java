package com.learnit.operations.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TextEditor {

	private static final String EXIT = "exit";
	private File file;

	public TextEditor(File fileToWrite) {
		this.file = fileToWrite;
	}

	public void start() throws IOException {
		System.out.println("********** Console text editor started **********");
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase(EXIT)) {
				saveToFile(sb);
				return;
			}
			sb.append(userInput).append(System.lineSeparator());
		}
	}

	private void saveToFile(StringBuilder sb) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(sb.toString());
		}
	}

	public void printToConsole() throws FileNotFoundException, IOException {
		System.out.println("All of your written text: ");
		try (FileReader fr = new FileReader(file)) {
			int content;
			while ((content = fr.read()) != -1) {
				System.out.print((char) content);
			}
		}
	}
}
