package com.learnit.operations.nix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOTests {

	public static void main(String[] args) {

		readAllLinesInFile();
	}

	public static void readFile(File file) {
		try (FileInputStream fileInput = new FileInputStream(file)) {
			int a = -1;
			while ((a = fileInput.read()) != -1) {
				System.out.print((char) a);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void writeInFile(File fileForWrite, String text) {
		try (FileOutputStream fileInput = new FileOutputStream(fileForWrite)) {
			byte[] textToWrite = text.getBytes();
			fileInput.write(textToWrite);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			;
		}
	}

	public static void readAllLinesInFile() {
		Path path = Paths.get("C:\\Users\\sasha\\Desktop\\test.txt");
		List<String> list = new ArrayList<String>();
		try {
			list = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.stream().forEach(System.out::println);
	}

}
