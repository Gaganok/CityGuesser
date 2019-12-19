package ua.kr.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	
	public String getCity() {
		return "";
	}
	
	public String setCity(@RequestParam String city ) {
		return "";
	}
}
