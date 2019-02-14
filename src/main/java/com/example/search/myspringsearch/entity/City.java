package com.example.search.myspringsearch.entity;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel("Details about the City Class")
public class City {

	@Size(min = 3, message = "City length  should be at least three")
	@ApiModelProperty(notes = "City Size  should be at least three")
	String city1;

	public City() {
	}

	public City(String city1) {
		super();
		this.city1 = city1;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	@Override
	public String toString() {
		return "RoadConnection [city1=" + city1 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city1 == null) ? 0 : city1.hashCode());
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
		City other = (City) obj;
		if (city1 == null) {
			if (other.city1 != null)
				return false;
		} else if (!city1.equals(other.city1))
			return false;
		return true;
	}

}
