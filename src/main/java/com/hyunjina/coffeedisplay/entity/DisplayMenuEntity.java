package com.hyunjina.coffeedisplay.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @class Name : DisplayMenuEntity.java
 * @Description : 전시 메뉴 엔티티
 * @Modification Information
 * @ Date			Author			Description
 * @ ------------	-------------	-------------
 * @ 2022. 7. 13.		나현지			최초 생성
 */
@Entity
@Table(name = "DISPLAY_MENU")		// 전시 메뉴 테이블
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder(toBuilder = true)
@IdClass(MenuProductId.class)
public class DisplayMenuEntity extends AbstractEntity {
	@Id
	@Comment("메뉴 아이디")
	private String menuId;
	
	@Id
	@Comment("상품 아이디")
	private String productId;					
	
	@Comment("메뉴 명")
	private String menuNm;
	
	
	
	@Comment("메뉴 가격")
	private BigDecimal menuPrice;
	
	@Comment("상품명")
	private String productNm;						
	
	@Comment("사용 여부")
	private String useYn; 
}
