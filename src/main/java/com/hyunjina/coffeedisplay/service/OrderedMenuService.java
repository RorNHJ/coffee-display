package com.hyunjina.coffeedisplay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyunjina.coffeedisplay.entity.OrderedMenuEntity;
import com.hyunjina.coffeedisplay.event.AbstractEvent;
import com.hyunjina.coffeedisplay.repository.OrderedMenuRepository;
/**
 * @class Name : OrderedMenuService.java
 * @Description : 주문된 메뉴 데이터를 조회 모델링
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 10.		나현지			최초 생성
 */
@Service
public class OrderedMenuService {
	private static final Logger logger = LoggerFactory.getLogger(OrderedMenuService.class);

	@Autowired
	private OrderedMenuRepository orderedMenuRepository;
	
	
	/**
	 * @author 나현지
	 * @date 2022. 7. 11.
	 * @description 주문 서비스에서 주문된 메뉴를 저장한다.
	 */
	public void saveOrderedMenu(AbstractEvent event) {
		orderedMenuRepository.save(OrderedMenuEntity.builder()
                                    		        .orderNo(event.getId())
                                    		        .menuId(event.getId2())
                                    		        .orderDt(event.getFrstCreDt())
                                    		        .frstCreUsrId(event.getFrstCreUsrId())
                                    		        .lastUpdUsrId(event.getLastUpdUsrId())
                                    		        .build()
                                    		        );
	}
	
}
