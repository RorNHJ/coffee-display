package com.hyunjina.coffeedisplay.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyunjina.coffeedisplay.dto.BestMenuDto;
import com.hyunjina.coffeedisplay.dto.MenuInfoDto;
import com.hyunjina.coffeedisplay.entity.DisplayMenuEntity;
import com.hyunjina.coffeedisplay.entity.OrderedMenuEntity;
import com.hyunjina.coffeedisplay.repository.DisplayMenuRepository;
import com.hyunjina.coffeedisplay.repository.OrderedMenuRepository;
/**
 * @class Name : MenuService.java
 * @Description : 메뉴, 인기메뉴 조회 서비스
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 10.		나현지			최초 생성
 */
@Service
public class DisplayMenuService {
	private static final Logger logger = LoggerFactory.getLogger(DisplayMenuService.class);

	@Autowired
	private DisplayMenuRepository displayMenuRepository;
	@Autowired
	private OrderedMenuRepository orderedMenuRepository;
	
	/**
	 * @author 나현지
	 * @date 2022. 7. 10.
	 * @description 사용중인 메뉴 목록 조회 후, 메뉴Id, 메뉴명, 가격을 리턴한다.
	 * 메뉴의 가격은 메뉴에 속한 상품들의 가격을 모두 합한 금액이다.
	 */
	public List<MenuInfoDto>  getMenuList() {
		
		List<MenuInfoDto> rtnList = new ArrayList<>();
		
		// 사용여부가 Y 인 메뉴 모두 조회
		List<DisplayMenuEntity> menuEntityList = displayMenuRepository.findByUseYnOrderByMenuId("Y"); 	
		
		menuEntityList.forEach( menuEntity -> rtnList.add( MenuInfoDto.builder()
                                                        		        .menuId(menuEntity.getMenuId())
                                                        		        .menuNm(menuEntity.getMenuNm())
                                                        		        .menuPrice(menuEntity.getMenuPrice())
                                                        		        .build()
                                                        		        )
		        );
		
		return rtnList;
	}
	

	/**
	 * @author 나현지
	 * @date 2022. 7. 10.
	 * @description 일주일간의 인기 메뉴 목록 조회
	 * 1. 일주일 간 주문한 메뉴 조회 
	 * 2. 메뉴Id 별로 주문한 건수 집계
	 * 3. 가장 많이 주문한 건수 순서대로 정렬 
	 * 4. 상위 3개만 추림
	 * 5. 메뉴 명 조회
	 */
	public List<BestMenuDto>  getBestMenuList() {
		final int COUNT_STAND = 3;			//인기 메뉴 조회 제한 건수
		final int FROM_DATE_STAND = 7;		//인기 메뉴 조회 제한 기간
		
		List<BestMenuDto>  bestMenuList = new ArrayList<BestMenuDto>();	//리턴 객체
		
		/** 일주일 간 주문한 메뉴 조회 */
		List<OrderedMenuEntity> orderedMenuEntityList =orderedMenuRepository.findByOrderDtBetween(LocalDateTime
                                                                                    		        .now()
                                                                                    		        .minusDays(FROM_DATE_STAND)
                                                                                    		        .withHour(0)
                                                                                    		        .withMinute(0)
                                                                                    		        .withSecond(0)
                                                                                    		        .withNano(0)
                                                                                    		        ,LocalDateTime.now()
                                                                                    		        );
		
		if(orderedMenuEntityList != null && !orderedMenuEntityList.isEmpty()) {
			
			/** 메뉴Id 별로 주문한 건수 집계 */
			List<Entry<String, Long>> groupingList = orderedMenuEntityList
                                			        .stream()
                                			        .collect(Collectors.groupingBy(OrderedMenuEntity::getMenuId , Collectors.counting()))
                                			        .entrySet()
                                			        .stream()
                                			        .collect(Collectors.toList());
			
			/** 가장 많이 주문한 건수 순서대로 정렬 */
			groupingList.sort((o1 ,o2)-> o1.getValue().compareTo(o2.getValue())*-1);
			
			
			/**상위 3개만 추림 */
			bestMenuList =   groupingList
        			        .subList(0, groupingList.size() >= COUNT_STAND ? COUNT_STAND : groupingList.size() )
        			        .stream()
        			        .map( e -> BestMenuDto.builder()
                    			                .menuId(e.getKey())
                    			                .orderCnt(e.getValue())
                    			                .build()
        			                )
        			        .collect(Collectors.toList());
			
			/* 4. 메뉴 명 조회 */
			bestMenuList.forEach( e -> e.setMenuNm(displayMenuRepository.findByByMenuId(e.getMenuId())));
		}
		
		return bestMenuList;
	}
}
