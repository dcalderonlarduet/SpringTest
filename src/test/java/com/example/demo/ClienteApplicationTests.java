package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Client;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ClienteApplicationTests {

	
	  @Autowired
	   WebApplicationContext webApplicationContext;
	   protected MockMvc mvc  ;
	   
	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	   
	   @Test
	   public void getListClient() throws Exception {
			  String uri = "/api/client/listClient";		
			  mvc   = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			   int status = mvcResult.getResponse().getStatus();
			   assertEquals(200, status);
			   String content = mvcResult.getResponse().getContentAsString();
			   Client[] clientlist = mapFromJson(content, Client[].class);			  
			   assertTrue(clientlist.length > 0);
			   	   
	   }

}
