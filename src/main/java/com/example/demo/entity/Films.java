package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Films {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="fname")
	private String fname;
    @Column(name="collection")
	private int collection;
    @Column(name="rating")
	private int rating;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_director", joinColumns =  @JoinColumn(name = "film_id") , inverseJoinColumns = 
			@JoinColumn(name = "director_id") )
	private Set<Director> directors=new HashSet();
//	public Set<Director> getDirector() {
//		return directors;
//	}

	public Films(String fname, int id, int collection, int rating, Set<Director> directors) {
		super();
		this.fname = fname;
		this.id = id;
		this.collection = collection;
		this.rating = rating;
		this.directors = directors;
	}

	public Films() {
		super();
	}

	public String getfName() {
		return fname;
	}

	public void setName(String fname) {
		this.fname = fname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public Set<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + collection;
		result = prime * result + id;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + rating;
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
		Films other = (Films) obj;
		if (collection != other.collection)
			return false;
		if (id != other.id)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	

}
