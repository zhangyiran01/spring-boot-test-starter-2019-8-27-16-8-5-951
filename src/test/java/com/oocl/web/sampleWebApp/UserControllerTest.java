package com.oocl.web.sampleWebApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void should_return_201_status_when_create_User()throws Exception{
		mockMvc.perform(post("/users")
                .contentType()
                .content("{\"username\":\"xiaoming\"}")
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());	
	}
	
	@Test
	public void should_return_ok_and_content_when_query__all_User()throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isok())
                .andExpect(MockMvcResultMatchers.content().string("{\"username\":\"hanmeimei\"}","{\"username\":\"lilei\"}"));
	

}
