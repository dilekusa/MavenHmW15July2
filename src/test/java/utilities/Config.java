package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	private static Properties config;
	static {
		try {
			System.out.println("opening properties file");
			String filePath = "./src/test/resources/testdata/configuration.properties";

			FileInputStream input = new FileInputStream(filePath);

			config = new Properties();

			config.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return config.getProperty(key);
	}
}
