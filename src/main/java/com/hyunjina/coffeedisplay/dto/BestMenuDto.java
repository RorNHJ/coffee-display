package com.hyunjina.coffeedisplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * @class Name : BestMenuDto.java
 * @Description : 인기메뉴
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 11.		나현지			최초 생성
 */
@Builder
@Getter
@Setter
public class BestMenuDto{
	private String menuId;     // 메뉴 아이디
	private String menuNm;     // 메뉴 명
	private Long orderCnt;     // 주문횟수
}
