package com.example.demo.common;

import lombok.Data;

@Data
public class ApiUtil<T> {

	private Integer status; // 응답 상태 코드 저장 (200, 400, 500)
	private String msg; // 응답 메시지 저장(성공, 실패 문자열)
	private T body; // 응답의 실제 데이터 저장(제네릭 활용)
	
	// 성공적인 응답을 반환 할 때 사용하는 생성자
	public ApiUtil(T body) {
		this.status = 200; // 통신 성공
		this.msg = "성공";
		this.body = body;
	}
	
	// 커스텀 상태코드와 메세지를 반환 시킬 때 사용하는 생성자 (예 : 에러 응답)
	public ApiUtil(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
		this.body = null;
	}
}
