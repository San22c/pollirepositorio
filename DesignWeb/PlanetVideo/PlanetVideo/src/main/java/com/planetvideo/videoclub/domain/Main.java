package com.planetvideo.videoclub.domain;

import org.springframework.web.client.RestTemplate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate(); 
		  String url = "http://www.omdbapi.com/?t=titanic&y=&plot=short&r=json";
		  //restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		  
		  Pelicula peli = restTemplate.getForObject(url, Pelicula.class); 
		  
		  
		  System.out.println(peli.getDirector());
	}

}
