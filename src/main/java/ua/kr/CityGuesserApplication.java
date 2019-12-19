package ua.kr;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ua.kr.service.CityService;

@SpringBootApplication
public class CityGuesserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityGuesserApplication.class, args);
	}
	
	@Autowired private CityService cityService;
	@PostConstruct
	private void startGame() throws Exception {
		cityService.startGame();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String  city = sc.nextLine();
			cityService.answer(city);
		}
	}

}
