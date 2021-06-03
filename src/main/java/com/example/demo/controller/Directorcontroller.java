package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Director;
import com.example.demo.service.Directorservice;

@RestController
public class Directorcontroller {
	@Autowired
	private Directorservice service;
	@PostMapping("/adddirector")
	private Director insertDirectors(@RequestBody Director directors)
	{
		return service.addDirector(directors);
		
	}
	@PutMapping("{name}")
	private void updateddirector(@RequestBody Director directors,@PathVariable String name)
	{
		service.updateDirector(directors, name);
		
	}
	@GetMapping("")
	private List<Director> findDirector()
	{
		return service.getDirector();
		
	}
	@GetMapping("{name}")
	private Director getDirectorbyname(@PathVariable String name)
	{
		System.out.println("hii");
		return service.getDirectorb(name);
		}
	@GetMapping("{fname}")
	private Director getDirectorbyfname(@PathVariable String fname,@RequestBody Director directors )
	{
		return  service.getDirectorf(directors, fname);
		
	}
}
