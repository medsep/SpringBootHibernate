package com.medAnno.springdemo;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create an array of strings
	private String[] data = {
			"Beware", "Deligence", "Journey"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//pick a random string from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
