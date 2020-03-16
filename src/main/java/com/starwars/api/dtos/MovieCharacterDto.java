package com.starwars.api.dtos;

import java.util.List;

import com.starwars.api.models.MovieCharacter;

public class MovieCharacterDto {

	private List<MovieCharacter> results;
	private Metadata metadata;
	
	public MovieCharacterDto(List<MovieCharacter> movieCharacters){
		this.results = movieCharacters;
	}
	
	public MovieCharacterDto(List<MovieCharacter> movieCharacters, Metadata metadata){
		this.results = movieCharacters;
		this.metadata = metadata;
	}
	
	public List<MovieCharacter> getResults() {
		return results;
	}

	public void setResults(List<MovieCharacter> movieCharacters) {
		this.results = movieCharacters;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	public static class Metadata{
		
		private long totalNumberOfCharacters;
		private long totalHeightOfCharactersInCM;
		private double totalHeightOfCharactersInInch;

		public Metadata(long totalNumberOfCharacters, long totalHeightOfCharactersInCM, double totalHeightOfCharactersInInch){
			this.totalNumberOfCharacters = totalNumberOfCharacters;
			this.totalHeightOfCharactersInCM = totalHeightOfCharactersInCM;
			this.totalHeightOfCharactersInInch = totalHeightOfCharactersInInch;
		}
		
		public long getTotalNumberOfCharacters() {
			return totalNumberOfCharacters;
		}

		public void setTotalNumberOfCharacters(long totalNumberOfCharacters) {
			this.totalNumberOfCharacters = totalNumberOfCharacters;
		}

		public long getTotalHeightOfCharactersInCM() {
			return totalHeightOfCharactersInCM;
		}

		public void setTotalHeightOfCharactersInCM(long totalHeightOfCharactersInCM) {
			this.totalHeightOfCharactersInCM = totalHeightOfCharactersInCM;
		}

		public double getTotalHeightOfCharactersInInch() {
			return totalHeightOfCharactersInInch;
		}

		public void setTotalHeightOfCharactersInInch(double totalHeightOfCharactersInInch) {
			this.totalHeightOfCharactersInInch = totalHeightOfCharactersInInch;
		}
	}
}
