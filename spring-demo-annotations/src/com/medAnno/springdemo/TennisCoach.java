package com.medAnno.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	//field injection, using reflection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside the constructor");
	}
	
	/*
	//define setter method
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">>TennisCoach: inside the doSomeCrazyStuff() method");
		fortuneService = theFortuneService;
	}
	
	@Autowired
	private TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	//define init method.
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Pracise Smarter";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	}
