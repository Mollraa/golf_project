package com.golf.app;

import java.util.Scanner;
import com.golf.member.MemberService;

import oracle.jdbc.internal.OracleConnection.XSOperationCode;

public class Application {
	Scanner sn = new Scanner(System.in);
	MemberService ms = new MemberService();

	int menuNo = 0;

	public Application() {
		up();
	}

	private void up() {
		  System.out.println("⁣⁣⁣🌨🌨🌨🌨🌨🌨🌨🌨");
	      System.out.println("  🚩   🚩   ❄ ");
	      System.out.println(" ❄ 🚩🏂     🌲");
	      System.out.println("🌲       🚩    🌲");
	      System.out.println("🌲🚩      🏂   🌲");
	      System.out.println(" ☃  📍🏁📍  ❄  🌲");
	      System.out.println("-----------------");
	      System.out.println("[ GolfZon Yedam ]");
	      System.out.println("-----------------");
	      System.out.println("| 1. 로그인 | 2. 상담(비회원) | 3. 종료 |");
	      System.out.println("=====================================");
		while (true) {
			menuNo = Integer.parseInt(sn.nextLine());
			switch (menuNo) {
			case 1:
				ms.doLogin();
				if(MemberService.memberInfo != null) {
					new ManageMent();
				}
				break;
			case 2:
				System.out.println("[전화 번호    > 053-123-1234        ]");	
				System.out.println("[상담가능 시간 > pm 07:00 - AM 11:00 ]");		
//				System.out.println("| 1. 방문예약 | 2. 전화상담 |");
//				int num1 = Integer.parseInt(sn.nextLine());
//				if(num1 == 1) {
//					System.out.println("날짜 선택 > ");
//				}else if (num1 == 2) {
//					System.out.println("[전화 번호    > 053-123-1234       ]");	
//					System.out.println("[상담가능 시간 > pm 07:00 - AM 11:00]");		
//				}
				break;
//				System.out.println("| 1. 회원가입 | 2. 프로등록 |");
//				int num = Integer.parseInt(sn.nextLine());
//				if (num == 1) {
//					ms.memberStart();
//					System.out.println("회원등록이 완료되었습니다.");
//					
//				} else if (num == 2) {
//					try {
//						if (ProService.proInfo.getRole().equals("0")) {
//							System.out.println("프로등록 > ");
//						}
//					} catch (Exception e) {
//						System.out.println("관리자로 로그인해 주세요.2");
//					}
//				}
//				break;
			case 3:
				System.out.println("종료되었습니다.");
				break;
//				System.out.println("| 1. 방문예약 | 2. 전화상담 |");
//				int num1 = Integer.parseInt(sn.nextLine());
//				if(num1 == 1) {
//					System.out.println("날짜 선택 > ");
//				}else if (num1 == 2) {
//					System.out.println("전화 번호 > 053-123-1234 ");	
//					System.out.println("상담가능 시간 > pm 07:00 - AM 11:00");		
//				}
//				break;
//			case 4:
//				System.out.println("종료되었습니다.");
//				break;
			}
		}

	}

}
