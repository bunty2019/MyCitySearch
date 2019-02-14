package com.example.search.myspringsearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.search.myspringsearch.controller.MySearchController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MyspringSearchApplicationTests {

	@Autowired
	private MySearchController controller;

//	@Autowired
//	private SearchService service;

	@Autowired
	private TestRestTemplate restTemplate;

//	@LocalServerPort
//	private int port;

	@Test
	public void contextLoads() {

		assertThat(controller).isNotNull();
	}

	@Test
	public void testShouldReturnCityPathState() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/connected/Boston/Newark", String.class))
				.contains("have a path to each other");
	}

}
