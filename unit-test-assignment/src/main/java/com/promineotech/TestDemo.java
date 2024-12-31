package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	public int addPositive(int a, int b) {
		if( a > 0 && b > 0) {
			if(a<=0||b<=0) {
				throw new IllegalArgumentException("Both parameters must be positive!");
			}
			
		}return a+b;
		
	}
	
    public int multiplyPositive(int a, int b) {
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("Neither number can be zero");
        }
        return a * b;
    }
	
    public int randomNumberSquared() {
        int randomInt = getRandomInt();
        return randomInt * randomInt;
    }

    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;  // Generates a number between 1 and 10
    }
    
}
