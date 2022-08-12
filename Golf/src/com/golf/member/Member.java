package com.golf.member;

import lombok.Data;

@Data
public class Member { 
//	MEMBER_ID   NOT NULL VARCHAR2(20)  
//	MEMBER_PW   NOT NULL VARCHAR2(20)  
//	MEMBER_NAME NOT NULL VARCHAR2(20)  
//	MEMBER_TEL  NOT NULL VARCHAR2(20)  
//	MEMBER_ADDR          VARCHAR2(200) 
//	DAY_START            DATE          
//	DAY_END              DATE          
//	PAY_LESSON           NUMBER        
//	PAY_PRAC             NUMBER        
//	ROLE                 CHAR(1)  
//	PRO_NAME             VARCHAR2(20)  
	
	private String memberId; // 아이디
	private String memberPw; // 비번
	private String memberName; // 이름
	private String memberTel; // 전화번호
	private String memberAddr; // 주소
	private String dayStart; //연습장 시작
	private String dayEnd; //연습장 마지막
	private int payLesson; // 레슨결재
	private int payPrac; // 연습장결재
	private String role; // 롤값
	private String proName;
	

}
