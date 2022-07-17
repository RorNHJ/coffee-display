package com.hyunjina.coffeedisplay.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ORDERED_MENU")		// 주문한 메뉴 테이블
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuperBuilder(toBuilder = true)
@IdClass(OrderMenuId.class)
public class OrderedMenuEntity extends AbstractEntity {
	@Id
	@Comment("주문번호")
	private String orderNo;
	
	@Id
	@Comment("메뉴아이디")
	private String menuId;	 
	
	@Comment("주문 일시")
	private LocalDateTime  orderDt;
}
