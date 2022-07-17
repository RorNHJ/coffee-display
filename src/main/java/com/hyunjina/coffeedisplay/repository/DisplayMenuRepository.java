package com.hyunjina.coffeedisplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hyunjina.coffeedisplay.entity.DisplayMenuEntity;
import com.hyunjina.coffeedisplay.entity.MenuProductId;
@Repository
public interface DisplayMenuRepository  extends JpaRepository<DisplayMenuEntity, MenuProductId> {
	
	/* 메뉴 사용여부(Y/N)에 따른 메뉴 목록 조회 */
	@Query(value="  SELECT *"
			+ "		FROM DISPLAY_MENU A "
			+ "		WHERE A.USE_YN=?1"
			+ "		GROUP BY A.MENU_ID"
			,nativeQuery=true)
	List<DisplayMenuEntity> findByUseYnOrderByMenuId(String useYn);
	
	
	/* 메뉴id로 조회 메뉴 정보 조회 */
	@Query(value=" SELECT A.MENU_NM "
			+ "    FROM DISPLAY_MENU A "
			+ "    WHERE A.MENU_ID=?1"
			+ "    GROUP BY A.MENU_ID"
			,nativeQuery=true)
	String findByByMenuId(String menuId);
}