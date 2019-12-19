package ua.kr.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kr.component.CityImportComponent;

@Service
public class CityService {
	@Autowired
	private CityImportComponent cityImport;

	private List <String> cities;
	private String currentCity;
	private char lastChar;

	public void startGame() throws Exception {
		cities = cityImport.importCity();
		currentCity = cities.get(ThreadLocalRandom.current().nextInt(cities.size()));
		lastChar = currentCity.charAt(currentCity.length() - 1);
		check();
		prompt();

	}

	public void answer( String city ) {
		if (Character.toLowerCase(city.charAt(0)) == lastChar) {
			if (cities.contains(city)) {
				currentCity = city;
				lastChar = currentCity.charAt(currentCity.length() - 1);
				check();

				//prompt();

				cities.remove(currentCity);
				
				Optional<String> opt = cities.stream().filter(cit -> 
					Character.toLowerCase(cit.charAt(0)) == lastChar
				).findFirst();
				
				if(opt.isPresent()) {
					currentCity = opt.get();
					lastChar = currentCity.charAt(currentCity.length() - 1);
					check();
					prompt();
					cities.remove(currentCity);
				} else {
					System.out.println("You Won!!!");
				}
			}

		}
	}


	private void prompt() {
		System.out.println(currentCity);
		System.out.println("Тебе на " + lastChar);
	}

	private void check() {
		if (lastChar == 'ы' || lastChar == 'ь') {
			lastChar = currentCity.charAt(currentCity.length() - 2);
		}
	}
}
