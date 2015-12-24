package com.jersey.ws;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("");
			URLClassLoader urlClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
			urlClassLoader.l
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
