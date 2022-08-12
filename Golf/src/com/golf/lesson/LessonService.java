package com.golf.lesson;

import java.util.List;
import java.util.Scanner;

import com.golf.app.Application;
import com.golf.member.MemberManage;

public class LessonService {
	public static Lesson proInfo = null;
	Scanner sn = new Scanner(System.in);

	//레슨변경
	public void updaterPlay() {
		Lesson lesson = new Lesson();
		
		System.out.println("변경할 프로님 성함을 입력하세요 > ");
		String name = sn.nextLine();
		System.out.println("변경할 시간을 입력해 주세요 > ");
		String time = sn.nextLine();
		
		lesson.setProName(name);
		lesson.setProTime(time);
		
		int result = LessonManage.getInstance().update(lesson);
		if (result == 1) {
			System.out.println("[ 변경되었습니다 ]");
		} else {
			System.out.println("[ 변경 실패 ]");
			//다시입력하세 주십시오
		}
	}
	//스캐쥴조회
	public void getPlay() {
		List<Lesson> list = LessonManage.getInstance().getPlay();
		for (Lesson lesson : list) {
			System.out.println("==========================================");
			System.out.println("| 선생님 : " + lesson.getProName());
			System.out.println("| 시간표 : " + lesson.getProTime());
			System.out.println("| 전화번호 : " + lesson.getProTel());
			System.out.println("==========================================");
		}
	}
}
