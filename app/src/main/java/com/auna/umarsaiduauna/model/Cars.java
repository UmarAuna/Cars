package com.auna.umarsaiduauna.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Cars{

	@SerializedName("gender")
	private String gender;

	@SerializedName("start_year")
	private int startYear;

	@SerializedName("id")
	private int id;

	@SerializedName("countries")
	private List<String> countries;

	@SerializedName("end_year")
	private int endYear;

	@SerializedName("colors")
	private List<String> colors;

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setStartYear(int startYear){
		this.startYear = startYear;
	}

	public int getStartYear(){
		return startYear;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCountries(List<String> countries){
		this.countries = countries;
	}

	public List<String> getCountries(){
		return countries;
	}

	public void setEndYear(int endYear){
		this.endYear = endYear;
	}

	public int getEndYear(){
		return endYear;
	}

	public void setColors(List<String> colors){
		this.colors = colors;
	}

	public List<String> getColors(){
		return colors;
	}

	@Override
 	public String toString(){
		return 
			"Cars{" + 
			"gender = '" + gender + '\'' + 
			",start_year = '" + startYear + '\'' + 
			",id = '" + id + '\'' + 
			",countries = '" + countries + '\'' + 
			",end_year = '" + endYear + '\'' + 
			",colors = '" + colors + '\'' + 
			"}";
		}
}