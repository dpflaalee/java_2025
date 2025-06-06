package com.example.demo.kma;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/weather")
	public String weather(){ return "weather";}
	
	@GetMapping( value = "/weatherapi", produces="application/xml; charset=UTF-8")
	@ResponseBody
	public String weatherapi() throws URISyntaxException {return weatherService.getWetherResponse();}
}
