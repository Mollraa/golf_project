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
		  System.out.println("β£β£β£π¨π¨π¨π¨π¨π¨π¨π¨");
	      System.out.println(" βπ©βββπ©ββ β ");
	      System.out.println("βββπ©πβββ βπ²");
	      System.out.println("π²βββββββπ©ββ βπ²");
	      System.out.println("π²π©ββββββπ   π²");
	      System.out.println("ββββπππβββ βπ²");
	      System.out.println("-----------------");
	      System.out.println("[ GolfZon Yedam ]");
	      System.out.println("-----------------");
	      System.out.println("| 1. λ‘κ·ΈμΈ | 2. μλ΄(λΉνμ) | 3. μ’λ£ |");
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
				System.out.println("[μ ν λ²νΈ    > 053-123-1234        ]");	
				System.out.println("[μλ΄κ°λ₯ μκ° > pm 07:00 - AM 11:00 ]");		
//				System.out.println("| 1. λ°©λ¬Έμμ½ | 2. μ νμλ΄ |");
//				int num1 = Integer.parseInt(sn.nextLine());
//				if(num1 == 1) {
//					System.out.println("λ μ§ μ ν > ");
//				}else if (num1 == 2) {
//					System.out.println("[μ ν λ²νΈ    > 053-123-1234       ]");	
//					System.out.println("[μλ΄κ°λ₯ μκ° > pm 07:00 - AM 11:00]");		
//				}
				break;
//				System.out.println("| 1. νμκ°μ | 2. νλ‘λ±λ‘ |");
//				int num = Integer.parseInt(sn.nextLine());
//				if (num == 1) {
//					ms.memberStart();
//					System.out.println("νμλ±λ‘μ΄ μλ£λμμ΅λλ€.");
//					
//				} else if (num == 2) {
//					try {
//						if (ProService.proInfo.getRole().equals("0")) {
//							System.out.println("νλ‘λ±λ‘ > ");
//						}
//					} catch (Exception e) {
//						System.out.println("κ΄λ¦¬μλ‘ λ‘κ·ΈμΈν΄ μ£ΌμΈμ.2");
//					}
//				}
//				break;
			case 3:
				System.out.println("μ’λ£λμμ΅λλ€.");
				break;
//				System.out.println("| 1. λ°©λ¬Έμμ½ | 2. μ νμλ΄ |");
//				int num1 = Integer.parseInt(sn.nextLine());
//				if(num1 == 1) {
//					System.out.println("λ μ§ μ ν > ");
//				}else if (num1 == 2) {
//					System.out.println("μ ν λ²νΈ > 053-123-1234 ");	
//					System.out.println("μλ΄κ°λ₯ μκ° > pm 07:00 - AM 11:00");		
//				}
//				break;
//			case 4:
//				System.out.println("μ’λ£λμμ΅λλ€.");
//				break;
			}
		}

	}

}
