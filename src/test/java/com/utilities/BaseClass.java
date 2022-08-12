package com.utilities;

import java.io.File;
import java.util.ArrayList;

import io.restassured.path.json.JsonPath;

public class BaseClass {
	static JsonPath jsonPath;
	public static JsonPath fileReader() {
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\rcb.json");
		jsonPath = new JsonPath(file);
		return jsonPath;
	}
	
	public ArrayList<String> getData(int len,String data) {
		ArrayList<String> list = new ArrayList<String>();
				for(int i=0;i<len;i++) {
					String string = jsonPath.getString("player["+i+"]."+data);
					list.add(string);
				}
		return list;
		

	}

}
