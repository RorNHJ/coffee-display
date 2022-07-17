package com.hyunjina.coffeedisplay.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@AutoConfigureMockMvc
class MenuControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	/** 
	 * @throws Exception 
	 * @description 커피_메뉴_목록_조회_API
	 * 
	 * @success http 응답 코드가 OK 이면 성공
	 * @success 메뉴 5개의 메뉴ID, 이름(메뉴명), 가격이 모두 값이 존재하면 성공
	 */
	@Test
	void 커피_메뉴_목록_조회_API() throws Exception {
		
		// when and then
		mockMvc.perform(get("/display/menu")
		        .accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].menuId").exists())       // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].menuNm").exists())       // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].menuPrice").exists())    // 가격
        		.andExpect(MockMvcResultMatchers.jsonPath("$[1].menuId").exists())       // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[1].menuNm").exists())       // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[1].menuPrice").exists())    // 가격
        		.andExpect(MockMvcResultMatchers.jsonPath("$[2].menuId").exists())       // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[2].menuNm").exists())       // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[2].menuPrice").exists())    // 가격
        		.andExpect(MockMvcResultMatchers.jsonPath("$[3].menuId").exists())       // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[3].menuNm").exists())       // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[3].menuPrice").exists())    // 가격
        		.andExpect(MockMvcResultMatchers.jsonPath("$[4].menuId").exists())       // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[4].menuNm").exists())       // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[4].menuPrice").exists())    // 가격
		;
		
		
	}

	
	/**
	 * @throws Exception 
	 * @description  최근 7일간 인기있는 메뉴 3개를 조회
	 * 
	 * @success http 응답 코드가 OK 이면 성공
	 * @success 메뉴 3개의 메뉴ID, 이름(메뉴명), 주문횟수 값이 존재하면 성공
	 * 
	 */
	@Test
	void 인기메뉴_목록_조회_API() throws Exception {
		// when and then
		mockMvc.perform(get("/display/best")
		        .accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].menuId").exists())        // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].menuNm").exists())        // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].orderCnt").exists())      // 주문횟수
        		
        		.andExpect(MockMvcResultMatchers.jsonPath("$[1].menuId").exists())        // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[1].menuNm").exists())        // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[1].orderCnt").exists())      // 주문횟수
        		
        		.andExpect(MockMvcResultMatchers.jsonPath("$[2].menuId").exists())        // 메뉴ID
        		.andExpect(MockMvcResultMatchers.jsonPath("$[2].menuNm").exists())        // 메뉴명
        		.andExpect(MockMvcResultMatchers.jsonPath("$[2].orderCnt").exists())      // 주문횟수
						;
	}

}
