package com.wxmimperio.jetty.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	private static String propFile = System.getProperty("user.dir")
			+ "/conf/global.properties";

	private PropertyUtil() {

	}

	private static class ProoertyHolder {

		private static Properties prop = new Properties();

		static {
			try {
				InputStream in = new BufferedInputStream(new FileInputStream(propFile));
				prop.load(in);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}

	public static Properties getInstance() {
		return ProoertyHolder.prop;
	}

}
