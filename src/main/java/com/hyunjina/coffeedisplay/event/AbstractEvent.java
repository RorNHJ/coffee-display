package com.hyunjina.coffeedisplay.event;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEvent  implements Serializable{
	
	private String id;
	private String id2;
	private String frstCreUsrId;				// 최초 생성자 아이디
	private String lastUpdUsrId;				// 최종 수정자 아이디
	private LocalDateTime  frstCreDt;			// 최초 생성 일자
	private LocalDateTime  lastUpdDt;			// 최종 수정 일자
}
