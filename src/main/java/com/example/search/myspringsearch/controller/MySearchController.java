package com.example.search.myspringsearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.search.myspringsearch.entity.City;
import com.example.search.myspringsearch.exception.CityNotFoundException;
import com.example.search.myspringsearch.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Controller for City  Searches")
@RestController
public class MySearchController {

	Logger mylogger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public SearchService searchservice;

	@ApiOperation(value = "Searches using REST  if  two Cities are Connected  via  Road")
	@GetMapping(path = "/connected/{origin}/{destination}")
	public String getSearch(@PathVariable String origin, @PathVariable String destination)
			throws CityNotFoundException {
		mylogger.debug(">>>>>>>>>>>>>>>>>>>>>>>>inside Search Controller");
		// check if Cities are valid Cities or throw Exception
		List<City> cityList = searchservice.getCityList();
		cityList.stream().forEach(System.out::println);
		if (!cityList.contains(new City(origin)) || !cityList.contains(new City(destination))) {
			throw new CityNotFoundException("City is not a  Valid City in the list of cities");
		}
		boolean status = searchservice.doesPathExistUser(origin, destination);
		// System.out.println("Status :" + status);
		if (status) {
			return "Cities " + origin + " and  " + destination + " have a path to each other";
		} else {

			return ("Cities " + origin + " and  " + destination + " do not have a path to each other");

		}
	}

	@ApiOperation(value = "Searches using Request Parameter  if  two Cities are Connected  via  Road")
	@RequestMapping(value = "/connected", method = RequestMethod.GET)
	// @ResponseBody
	public String getMVCSearch(@RequestParam("origin") String origin, @RequestParam("destination") String destination,
			ModelMap model) throws CityNotFoundException {
		mylogger.debug(">>>>>>>>>>>>>>>>>>>>>>>>inside Search Controller");
		mylogger.debug(">>>>>>>>>>>>>>>>>>>>>>>>origin  and destination:" + origin + "   " + destination);

		List<City> cityList = searchservice.getCityList();
		cityList.stream().forEach(System.out::println);
		if (!cityList.contains(new City(origin)) || !cityList.contains(new City(destination))) {
			throw new CityNotFoundException("Citi is not a  Valid City in the list of cities");
		}
		boolean status = searchservice.doesPathExistUser(origin, destination);
		// System.out.println("Status :" + status);
		if (status) {
			return "Cities " + origin + " and  " + destination + " have a path to each other";
		} else {

			return ("Cities " + origin + " and  " + destination + " do not have a path to each other");

		}
	}

}
