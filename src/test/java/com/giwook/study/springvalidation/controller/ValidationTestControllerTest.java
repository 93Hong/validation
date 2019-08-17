package com.giwook.study.springvalidation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giwook.study.springvalidation.entity.TestEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class ValidationTestControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@DisplayName("정상 Request")
	@Test
	void test_request_ok() throws Exception {

		TestEntity testEntity = TestEntity.builder()
			.hasCar(true)
			.carName("car")
			.age(27)
			.name("giwook")
			.build();
		String requestContents = objectMapper.writeValueAsString(testEntity);

		final String testUri = "/test";
		mockMvc.perform(post(testUri)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(requestContents)
		)
			.andDo(print())
			.andExpect(status().isOk())
		;

	}

	@DisplayName("오류 Request : bean validation error")
	@Test
	void test_request_bean_validation_error() throws Exception {

		TestEntity testEntity = TestEntity.builder()
			.hasCar(true)
			.carName("car")
			.age(6)
			.name("giwook")
			.build();
		String requestContents = objectMapper.writeValueAsString(testEntity);

		final String testUri = "/test";
		mockMvc.perform(post(testUri)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(requestContents)
		)
			.andDo(print())
			.andExpect(status().isBadRequest())
		;

	}


}