package com.hyunjina.coffeedisplay.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @class Name : MenuInfoDto.java
 * @Description : 메뉴 정보 return dto
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 10.		나현지			최초 생성
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfoDto {
	private String menuId;         // 메뉴 아이디
	private String menuNm;         // 메뉴 명
	private BigDecimal menuPrice;  // 가격
}
