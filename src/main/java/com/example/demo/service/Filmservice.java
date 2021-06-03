package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Director;
import com.example.demo.entity.Films;
import com.example.demo.repository.Directorrepository;
import com.example.demo.repository.Filmrepository;

@Service
public class Filmservice {
	@Autowired
	private Filmrepository repo;
	@Autowired
	private Directorrepository repo1;

	public void addfilms(Films film, int direcotrId) {
		Director d = repo1.findById(direcotrId).get();
		d.getFilm().add(film);
		film.getDirectors().add(d);
		repo.save(film);
		//System.out.println(film);
		repo1.save(d);

		// Director dr=repo1.findById(id);
		// film.setDirectors(dr);
		// return repo.save(film);
	}

	public void deletefilm(String name) throws InvalidnameException {
		Films fs = repo.findByName(name);
		System.out.println(fs);
		if (fs != null) {
			repo.delete(fs);
		} else {
			throw new InvalidnameException();
		}
	}

	public List<Films> getFilms() {
		return repo.findAll();

	}

}
