package com.learnit.operations.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

public class ConfigReader {

	private Path config;

	public ConfigReader(Path config) {
		this.config = config;
	}

	public Path getConfig() {
		return config;
	}

	public void setConfig(Path config) {
		this.config = config;
	}

	public String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
		String valueByKey = "";
		List<String> readAllLines = Files.readAllLines(configMapFilePath);
		for (String string : readAllLines) {
			if (string.contains(keyName)) {
				valueByKey = string.substring(string.indexOf('=') + 1, string.length());
			}
		}
		return valueByKey;
	}
}
