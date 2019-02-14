package com.example.search.myspringsearch.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.search.myspringsearch.entity.City;
import com.example.search.myspringsearch.service.dao.SearchDAO;

@Service
public class SearchService {

	@Autowired
	private SearchDAO searchDAO;

	private LinkedList<City>[] blist;

	Logger mylogger = LoggerFactory.getLogger(this.getClass());

	public boolean doesPathExistUser(String city1, String city2) {
		// TODO Auto-generated method stub
		return isReachable(new City(city1), new City(city2), searchDAO.getCitiData());
	}

	public List<City> getCityList() {
		return searchDAO.getCitiData();
	}

	// prints breadth first traversal from a given source src to Destination des
	public Boolean isReachable(City src, City des, List<City> alist) {

		blist = searchDAO.getAdjacentImmediateNodes(); // List of Nodes adjacent to a Node
		// Mark all the vertices as not visited(by default set false)
		boolean visited[] = new boolean[alist.size()];

		// Create a queue for BFS
		LinkedList<City> bfsqueue = new LinkedList<City>();

		// Mark the current node as visited and enqueue it

		mylogger.debug("index of  src: " + alist.indexOf(src));
		mylogger.debug("index of des: " + alist.indexOf(des));
		visited[alist.indexOf(src)] = true;
		bfsqueue.add(src);

		mylogger.debug("bfs queue size is : " + bfsqueue.size());
		// 'i' will be used to get all adjacent vertices of a vertex
		Iterator<City> itr;
		while (bfsqueue.size() != 0) {
			// Dequeue a node from queue
			src = bfsqueue.poll();

			City cty;
			itr = blist[alist.indexOf(src)].listIterator();
			System.out.println("alist.indexOf(s):" + blist[alist.indexOf(src)].size());
			// Get all adjacent nodes of the dequeued node
			// If a adjacent has not been visited, then mark it
			// visited and enqueue/add it to the bfs queue

			while (itr.hasNext()) {
				cty = itr.next();

				// If this adjacent node is the destination node
				// destination is found so return true
				if (cty.equals(des))
					return true;

				// Else, continue to do BFS
				mylogger.debug("Breadth First Search:" + cty + "[ " + alist.indexOf(cty) + " ");
				mylogger.debug(
						"Breadth First Search is Node  Visited:" + cty + "[ " + visited[alist.indexOf(cty)] + " ]");
				if (!visited[alist.indexOf(cty)]) {
					visited[alist.indexOf(cty)] = true;
					bfsqueue.add(cty);
					mylogger.debug(">>>>>>bfs queue size is : " + bfsqueue.size());
				}
			}
		}

		// If BFS traversal is complete without visiting the destination
		// then no destination found from source
		return false;
	}

}
