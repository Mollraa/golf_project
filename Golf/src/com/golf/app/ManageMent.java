package com.golf.app;

import java.util.Scanner;

import com.golf.lesson.LessonService;
import com.golf.member.MemberService;

public class ManageMent {

	Scanner sn = new Scanner(System.in);
	MemberService ms = new MemberService();
	LessonService ls = new LessonService();

	int menuNo = 0;

	public ManageMent() {
		run();
	}

	private void run() {
		while (true) {
			menuInfo();
			// | 1.회원등록 | 2.회원수정 | 3.회원조회(전체) | 4. 회원조회(단건) | 5. 프로정보조회 | 6.스캐쥴변경 | 7.회원삭제 |
			// 8. 매출 | 9.종료 |
			if (MemberService.memberInfo.getRole().equals("1")) {
				if (menuNo == 1) {
					ms.registerCustomer();
				} else if (menuNo == 2) {
					ms.updateMember();
				} else if (menuNo == 3) {
					ms.getDetailmember();
				} else if (menuNo == 4) {
					ms.MemberInfo();
				} else if (menuNo == 5) {

				} else if (menuNo == 6) {

				} else if (menuNo == 7) {
					ms.deleteMember();
				} else if (menuNo == 8) {
					ms.sumMember();
				} else if (menuNo == 9) {
					System.out.println("종료되었습니다.");
					if (MemberService.memberInfo != null) {

						MemberService.memberInfo = null;
					}
					break;
				}
			} else if (MemberService.memberInfo.getRole().equals("0")) {
				if (menuNo == 1) {
					ms.MemberInfo();
				} else if (menuNo == 2) {
					ls.getPlay();
				} else if (menuNo == 3) {
					System.out.println("종료되었습니다.");
					if (MemberService.memberInfo != null) {

						MemberService.memberInfo = null;
					}
					
					new Application();
					break;

				}
			}
		}
	}

	private void menuInfo() {
		// role == 1, admin(관리자)
		if (MemberService.memberInfo.getRole().equals("1")) {
			System.out.println(
					"| 1.회원등록 | 2.회원수정 | 3.회원조회(전체) | 4. 회원조회(단건) | 5. 프로정보조회 | 6.스캐쥴변경 | 7.회원삭제 | 8. 매출 | 9.종료 |");
		}
		// role == 0 회원
		else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("| 1. 나의 정보 조회 | 2. 레슨일정 조회 | 3. 종료 |");
		}
		System.out.println("입력>");
		menuNo = Integer.parseInt(sn.nextLine());

	}
}
