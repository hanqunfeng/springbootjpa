package com.example;

import com.example.dao.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringbootjpaApplicationTests {
	@Autowired
	PersonRepository personRepository;

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;


	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void repositoryFindbyNameTest() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String content = objectMapper.writeValueAsString(personRepository.findByAddress("成都"));
		System.out.println("repositoryFindbyNameTest content == " + content);


	}

	@Test
	public void q1Test() throws Exception {
		String uri = "/q1?address=南京";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("q1Test content == " + content);
	}

	@Test
	public void saveTest() throws Exception {
		String uri = "/save?name=呵呵&age=10&address=上海";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("saveTest content == " + content);
	}

}
