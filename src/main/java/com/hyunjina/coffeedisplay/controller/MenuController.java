package com.hyunjina.coffeedisplay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyunjina.coffeedisplay.dto.BestMenuDto;
import com.hyunjina.coffeedisplay.dto.MenuInfoDto;
import com.hyunjina.coffeedisplay.service.DisplayMenuService;

/**
 * @class Name : MenuController.java
 * @Description : 메뉴 조회, 인기메뉴 조회 컨트롤러
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 10.		나현지			최초 생성
 */
@RestController
@RequestMapping("/display")
public class MenuController {
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private DisplayMenuService displayMenuService;
	
	/**
	 * @author 나현지
	 * @date 2022. 7. 10.
	 * @description 사용중인 모든 메뉴 조회
	 */
	@GetMapping("/menu")
	public ResponseEntity<List<MenuInfoDto>> searchMenuList() throws Exception{
		return 	ResponseEntity
		        .status(HttpStatus.OK)
		        .body(displayMenuService.getMenuList());
	}
	
	
	/**
	 * @author 나현지
	 * @date 2022. 7. 10.
	 * @description 인기 메뉴 조회
	 */
	@GetMapping("/best")
	public ResponseEntity<List<BestMenuDto>> searchBestMenuList() throws Exception{
		return 	ResponseEntity
		        .status(HttpStatus.OK)
		        .body(displayMenuService.getBestMenuList());
	}
	
}
