package com.project.brunch.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonRespDto<T> {
	private int statusCode; // 1 정상, -1 실패, 0 변경없음 등의 응답
	private T data; // select, 응답 시 데이터 넣어줌 → 동적 Object
}