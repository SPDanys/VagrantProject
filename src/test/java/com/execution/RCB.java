package com.execution;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.utilities.BaseClass;
import io.restassured.path.json.JsonPath;

public class RCB extends BaseClass{
	
	File file;
	int foriegnplayerCounter = 0;
	JsonPath jsonPath;
	static int length;

	@BeforeClass
	public void get_rcb_player_list() {
		jsonPath = fileReader();
	}
	
	@Test
	public void validate_foriegn_players() {
		length = jsonPath.getInt("player.size");
		ArrayList<String> data = getData(length, "country");
		for (String x : data) {
			if (!(x.equals("India"))) {
				foriegnplayerCounter++;
			}
		}
		System.out.println("Total numbers of forien players are : " + foriegnplayerCounter);
		Assert.assertTrue(foriegnplayerCounter <= 4);
		
	}
	@Parameters({"role"})
	@Test
	private void validate_team_has_one_wicket_keeper(String name) {
	
		boolean rolecheck = false;
		ArrayList<String> roleData = getData(length, "role");
		Iterator<String> iterator = roleData.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if (string.equals(name)) {				
			rolecheck = true;
			break;
			}
		}
			Assert.assertTrue(rolecheck);

	}
	
	
}
