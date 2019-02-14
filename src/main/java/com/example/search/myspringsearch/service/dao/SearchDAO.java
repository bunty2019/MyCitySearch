package com.example.search.myspringsearch.service.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.search.myspringsearch.entity.City;

@Repository
public class SearchDAO {

	List<City> alist; // array list

	private static LinkedList<City> blist[]; // Adjacent node List for nodes immediate to a node

	private Logger mylogger = LoggerFactory.getLogger(this.getClass());

	private void createAdjecentNodes() {
		int length = getCitiData().size();
		blist = new LinkedList[length];
		for (int i = 0; i < length; ++i)
			blist[i] = new LinkedList<City>();

		mylogger.debug("----------in searchDAO createAdjecentNodes()  linked list size " + blist.length);
	}

	public LinkedList<City>[] getAdjacentImmediateNodes() {

		createAdjecentNodes();

		addEdge(new City("Boston"), new City("New York"));
		addEdge(new City("New York"), new City("Newark"));
		addEdge(new City("Newark"), new City("Philadelphia"));
		addEdge(new City("Trenton"), new City("Albany"));
		addEdge(new City("New York"), new City("Cape Cod"));
		addEdge(new City("Niagara"), new City("Buffalo"));

		mylogger.debug("After Adding Edges link  size of List :" + blist.length);

		return blist;
	}

	private void addEdge(City src, City des) {
		mylogger.debug(" Adding Edges indexes : " + src + "[" + alist.indexOf(src) + "]    , " + des + "[ "
				+ alist.indexOf(des) + "]");
		blist[alist.indexOf(src)].add(alist.get(alist.indexOf(des)));
	}

	public List<City> getCitiData() {

		alist = new ArrayList<>();
		alist.add(new City("Boston"));
		alist.add(new City("Albany"));
		alist.add(new City("New York"));
		alist.add(new City("Newark"));
		alist.add(new City("Philadelphia"));
		alist.add(new City("Trenton"));
		alist.add(new City("Niagara"));
		alist.add(new City("Buffalo"));
		alist.add(new City("Cape Cod"));
		alist.add(new City("Niagara"));

		return alist;

	}

}
