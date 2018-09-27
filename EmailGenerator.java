package com.automationpractice;

import java.util.Random;

public class EmailGenerator {

	public static String getRandomEmail() {

		Random rad = new Random();
		return ("usename" + rad.nextInt(1000) + "@test.com");
	}
}
