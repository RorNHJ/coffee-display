package com.hyunjina.coffeedisplay.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hyunjina.coffeedisplay.entity.OrderMenuId;
import com.hyunjina.coffeedisplay.entity.OrderedMenuEntity;
@Repository
public interface OrderedMenuRepository  extends JpaRepository<OrderedMenuEntity, OrderMenuId> {
    
	/* 기간별 인기메뉴 조회*/
	List<OrderedMenuEntity> findByOrderDtBetween(LocalDateTime start, LocalDateTime end);
}