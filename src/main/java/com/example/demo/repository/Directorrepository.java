package com.example.demo.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Director;
@Repository
public interface Directorrepository extends JpaRepository<Director, Integer> {

	Director findByName(String name);
	@Query("select director from director join films where film.fname=:name")
	Director findByfName(@Param("fname") String fname);
     
	//Director findBynme(String name);



}
