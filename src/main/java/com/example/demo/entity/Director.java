package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Director {
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="dname")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="awardcount")
	private int awardcount;
	@ManyToMany(mappedBy = "directors")
	@JsonIgnore
	private Set<Films> film=new HashSet();
//	public Set<Films> getfilm() {
//		return film;
//	}

	
	public Director(int id, String name, int age, String gender, int awardcount, Set<Films> film) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.awardcount = awardcount;
		this.film = film;
	}
	public Director() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAwardcount() {
		return awardcount;
	}
	public void setAwardcount(int awardcount) {
		this.awardcount = awardcount;
	}
	public Set<Films> getFilm() {
		return film;
	}
	
	public void setFilm(Set<Films> film) {
		this.film = film;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + awardcount;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		if (age != other.age)
			return false;
		if (awardcount != other.awardcount)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}
