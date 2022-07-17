package com.hyunjina.coffeedisplay.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @class Name : OrderMenuId.java
 * @Description : 주문-메뉴 엔티티 복합키
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 13.		나현지			최초 생성
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenuId implements Serializable {
	
	@EqualsAndHashCode.Include
    private String menuId;
	
	@EqualsAndHashCode.Include
    private String orderNo;
	
}