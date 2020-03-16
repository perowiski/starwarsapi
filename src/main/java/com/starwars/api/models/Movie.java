/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.starwars.api.models;

import java.util.ArrayList;
import java.util.Date;

public class Movie{
	
	private String title;
	private float episode_id;
	private String opening_crawl;
	private String director;
	private String producer;
	private Date release_date;
	private ArrayList<String> characters;
	private ArrayList<String> planets;
	private ArrayList<String> starships;
	
	private ArrayList<String> vehicles;
	private ArrayList<String> species;
	private String created;
	private String edited;
	private String url;

	private long commentCount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(float episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public ArrayList<String> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<String> characters) {
		this.characters = characters;
	}

	public ArrayList<String> getPlanets() {
		return planets;
	}

	public void setPlanets(ArrayList<String> planets) {
		this.planets = planets;
	}

	public ArrayList<String> getStarships() {
		return starships;
	}

	public void setStarships(ArrayList<String> starships) {
		this.starships = starships;
	}

	public ArrayList<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<String> vehicles) {
		this.vehicles = vehicles;
	}

	public ArrayList<String> getSpecies() {
		return species;
	}

	public void setSpecies(ArrayList<String> species) {
		this.species = species;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	
	
}
