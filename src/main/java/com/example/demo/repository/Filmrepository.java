package com.example.demo.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Films;
@Repository
public interface Filmrepository extends JpaRepository<Films, Integer> {

	Films findByName(String name);

	

}
