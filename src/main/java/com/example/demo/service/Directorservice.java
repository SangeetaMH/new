package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Director;
import com.example.demo.repository.Directorrepository;

@Service
public class Directorservice {
	@Autowired
	private Directorrepository repo;
	
	public Director addDirector(Director director)
	{
		return repo.save(director);
		
	}
	public void updateDirector(Director directors,String name)
	{
		Director d=repo.findByName(name);
	    d.setAge(directors.getAge());
	    d.setAwardcount(directors.getAwardcount());
	    repo.save(d);
	}
	public List<Director> getDirector()
	{
		return repo.findAll();
		
	}
	public Director getDirectorb(String name)
	{
		return repo.findByName(name);
		
	}
	public Director getDirectorf(Director directors,String fname)
	{
		return repo.findByfName(fname);
	
	}
	
	
	

}
