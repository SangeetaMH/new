package com.example.demo.controller;

import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Director;
import com.example.demo.entity.Films;
import com.example.demo.service.Filmservice;
import com.example.demo.service.InvalidnameException;

@RestController
public class Filmcontroller {
	@Autowired
private Filmservice service;
	@PostMapping("/addfilms/{id}")
	private void addfilms(@RequestBody  Films film,@PathVariable int id)
	{
		 service.addfilms(film, id);
		
	}
	@DeleteMapping("{name}")
	private void deletefilm(@PathVariable String name) throws InvalidnameException
	{
		
			service.deletefilm(name);
	}
	@GetMapping("/")
	private List<Films> findFilms()
	{
		return service.getFilms();
		
	}

		
	
	
}
