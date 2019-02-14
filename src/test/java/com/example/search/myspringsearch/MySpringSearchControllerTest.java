package com.example.search.myspringsearch;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.search.myspringsearch.controller.MySearchController;
import com.example.search.myspringsearch.service.SearchService;

@RunWith(SpringRunner.class)
@WebMvcTest(MySearchController.class)
public class MySpringSearchControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	SearchService searchservice;

//	@Test
//	public void TestHomePage() throws Exception {
//		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"))
//				.andExpect(content().string(containsString("Welcome")));

//	}
}
