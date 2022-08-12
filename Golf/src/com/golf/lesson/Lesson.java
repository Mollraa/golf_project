package com.golf.lesson;

import lombok.Data;

@Data
public class Lesson {
// | 1. 로그인 | 2. 회원가입 | 3. 상담예약(비회원/예약 or 전화) | 4. 종료 |
	   
//나-> 연습장사장 (role 0) 
//member(role 0) 회원가입 : 아이디 비번 이름 전번 주소 시작일 담당프로 
//						레슨결제 레슨잔여 연습장결제 사물함선택 연습장마감기한 피드백 
//예약 : 레슨예약조회 *타석예약 *레슨예약 예약변경 예약취소
//재등록 : 연습장(1, 3, 6, 12 달) 레슨((10회, 20, 30, 50, 70)프로바꿀지) 사물함(사용여부) 
//(결제 : 현금 계좌 (환불 7일))

//   pro(관리자0, pro2) : 1,id 2,pw 3,이름 4,생년월일 5,전화번호 6,주소 7,pga 8,첫출근 9,월급 
//	      10,pga 11,role (매출> 12,연습장월매출 13,레슨월매출 14,연습장연간매출(2가지 방법 : 쿼리문 물어보기)
	   
//	PRO_NAME NOT NULL VARCHAR2(20) 
//	PRO_TIME          VARCHAR2(20) 
//	PRO_TEL           VARCHAR2(20) 
//	PGA               VARCHAR2(20) 
 
	private String proName; //이름
	private String proTime; //이름
	private String proTel; // 전화번호
	private String pga; //프로단계
	
}
