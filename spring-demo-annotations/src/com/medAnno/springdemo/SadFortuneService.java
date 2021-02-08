package com.medAnno.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Todat is a sad day!";
	}

}
