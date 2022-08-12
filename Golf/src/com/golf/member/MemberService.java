package com.golf.member;

import java.util.List;
import java.util.Scanner;

import com.golf.app.Application;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sn = new Scanner(System.in);

////	- 회원가입
//	public void memberStart() {
//		Member member = new Member();
////			pstmt.setString(1, member.getMemberId());
////			pstmt.setString(2, member.getMemberPw());
////			pstmt.setString(3, member.getMemberName());
////			pstmt.setString(4, member.getMemberTel());
////			pstmt.setString(4, member.getMemberAdd());
//
//		System.out.println("회원 ID >");
//		String id = sn.nextLine();
//
//		System.out.println("회원 PW >");
//		String pw = sn.nextLine();
//
//		System.out.println("성함 >");
//		String name = sn.nextLine();
//
//		System.out.println("휴대전화 >");
//		String tel = sn.nextLine();
//
//		System.out.println("주소 >");
//		String add = sn.nextLine();
//
//		member.setMemberId(id);
//		member.setMemberPw(pw);
//		member.setMemberName(name);
//		member.setMemberTel(tel);
//		member.setMemberAdd(add);
//
//		int result = MemberManage.getInstance().memberStart(member);
//		if (result == 1) {
//			System.out.println("[ 환영합니다 ]");
//		} else {
//			System.out.println("회원가입 실패했습니다.");
//		}
//	}
	// 회원등록
	public void registerCustomer() {
		Member member = new Member();
		System.out.println("등록할 회원 ID >");
		String id = sn.nextLine();

		System.out.println("회원 PW >");
		String pw = sn.nextLine();

		System.out.println("회원 이름 >");
		String name = sn.nextLine();

		System.out.println("전화번호 >");
		String tel = sn.nextLine();

		System.out.println("주소 >");
		String addr = sn.nextLine();

		System.out.println("시작일 >");
		String start = sn.nextLine();

		System.out.println("마지막날 >"); // 마지막날 계산식으로 출력? 첫날+3개월, 첫날+6개월
		String end = sn.nextLine();

		System.out.println("레슨비 >");
		int lesson = Integer.parseInt(sn.nextLine());

		System.out.println("연습장비 > ");
		int prac = Integer.parseInt(sn.nextLine());

		System.out.println("담당 프로 > ");
		String pro = sn.nextLine();

		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberTel(tel);
		member.setMemberAddr(addr);
		member.setDayStart(start);
		member.setDayEnd(end);
		member.setPayLesson(lesson);
		member.setPayPrac(prac);
		member.setRole("0");
		member.setProName(pro);

		int result = MemberManage.getInstance().registCustomer(member);

		if (result == 1) {
			System.out.println("고객 정보 등록 완료");

		} else {
			System.out.println("고객 정보 등록 실패");
		}
	}

//	- 로그인
//	   아이디, 비번, 이름, 주소, 폰번호, 등록일/마지막
	public void doLogin() {
		Member member = new Member();

		System.out.println("회원 ID > ");
		String id = sn.nextLine();
		System.out.println("비밀번호 > ");
		String pw = sn.nextLine();

		member = MemberManage.getInstance().loginInfo(id);

		// 아이디중복"이미 사용중인 아이디 입니다." 아이디틀림"아이디를 확인하셔 주십시오" 비번틀림"비밀번호를 확인하여 주십시오" 둘다틀림"다시
		// 입력하여주십시오" => 4가지 기능 필요
		try {
			if (member != null) {
				memberInfo = member;
			} else {
				System.out.println("등록되지 않은 아이디 입니다.");
				new Application();
			}
			if (member.getMemberPw().equals(pw)) {
				memberInfo = member;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");

				new Application();
			}
		} catch (Exception e) {
		}
	}

	// 로그아웃
	public void logout() {
		if (memberInfo != null)
			memberInfo = null;
	}

//	- 회원 정보 수정 	
//	  -> 비번, 이름, 주소, 폰번
	public void updateMember() {
		Member member = new Member();

		System.out.println(">> 변경할 ID를 입력해주세요 > ");
		String id = sn.nextLine();
		System.out.println(">> 변경할 이름을 입력해주세요 > ");
		String memName = sn.nextLine();
		System.out.println(">> 변경할 휴대전화 번호를 입력해주세요 > ");
		String memTel = sn.nextLine();
		System.out.println(">> 변경할 주소지를 입력해주세요 > ");
		String add = sn.nextLine();

		member.setMemberId(id);
		member.setMemberName(memName);
		member.setMemberTel(memTel);
		member.setMemberAddr(add);

		int result = MemberManage.getInstance().updateCustomer(member);
		if (result == 1) {
			System.out.println("[ 회원 정보가 변경되었습니다. ]");
		} else {
			System.out.println("[ 회원 정보가 변경되었습니다. ]");
		}

	}

// 관리자 - 회원조회
	public void getDetailmember() {

		System.out.println(">");
		String memberId = sn.nextLine();
		List<Member> list = MemberManage.getInstance().getDetailMember(memberId);
		for (Member member : list) {
			System.out.println("-----------------------------------------------");
			System.out.println("[ 회원 ID : " + member.getMemberId() + " ]");
			System.out.println("[ 회원명 : " + member.getMemberName() + " ]");
			System.out.println("[ 연락처 : " + member.getMemberTel() + " ]");
			System.out.println("[ 담당 프로님 : " + member.getProName() + " ]");
			System.out.println("[ 연습장 시작일 : " + member.getDayStart() + " ]");
			System.out.println("[ 연습장 마감일 : " + member.getDayEnd() + " ]");
			System.out.println("-----------------------------------------------");
		}

	}

//	- 회원정보 ->  단건 정보 조회
	public void MemberInfo() {

		System.out.println("고객 ID>");
		String memberId = sn.nextLine();

		Member member = MemberManage.getInstance().getmemBer(memberId);
		System.out.println(MemberService.memberInfo.getMemberId() + "님의 회원정보 입니다.");

//		   이름, 프로님 성함, 연습장 유효기간, 잔여 레슨횟수 조회, 연습장 등록일/마지막 요일.
		System.out.println("-----------------------------------------------");
		System.out.println("[ 회원 ID : " + member.getMemberId() + " ]");
		System.out.println("[ 회원명 : " + member.getMemberName() + " ]");
		System.out.println("[ 연락처 : " + member.getMemberTel() + " ]");
		System.out.println("[ 담당 프로님 : " + member.getProName() + " ]");
		System.out.println("[ 연습장 시작일 : " + member.getDayStart() + " ]");
		System.out.println("[ 연습장 마감일 : " + member.getDayEnd() + " ]");
		System.out.println("-----------------------------------------------");

	}

	// 회원삭제
	public void deleteMember() {
		System.out.println("삭제할 회원 ID > ");
		String memberId = sn.nextLine();

		int result = MemberManage.getInstance().deleteMember(memberId);
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제되지 않았습니다.");
		}
	}

	// 총매출
	public void sumMember() {
		List<Member> list = MemberManage.getInstance().getPay();
		int sum = 0;
		for (Member member : list) {
			System.out.println("▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷▷");
			System.out.println(" 레슨 매출 > " + member.getPayLesson());
			System.out.println(" 연습장 매출 > " + member.getPayPrac());
			System.out.println("판매 금액 > " + (member.getPayLesson() + member.getPayPrac()));
			System.out.println("◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁◁");
			sum += member.getPayLesson() + member.getPayPrac();
		}
		System.out.println("총 매출은 " + sum + "원 입니다.");
	}

}
