package idv.autumn.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class test {
	Properties prop = new Properties();
	String fileName = System.getProperty("jboss.server.config.dir") + "/one.properties";
	{
		try (FileInputStream fis = new FileInputStream(fileName)) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();

			System.out.println(prop.getProperty("name", "none"));
			System.out.println(prop.getProperty("age", "none"));
		}
	}
}