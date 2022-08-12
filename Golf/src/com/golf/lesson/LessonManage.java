package com.golf.lesson;

import java.util.ArrayList;
import java.util.List;

import com.golf.common.DAO;
import com.golf.member.Member;

public class LessonManage extends DAO {
	private static LessonManage lm = new LessonManage();

	private LessonManage() {

	}

	public static LessonManage getInstance() {
		return lm;
	}

	// 스캐쥴수정 메소드
	public int update(Lesson play) {
		int result = 0;
		try {
			conn();
			// UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]
			String sql = "update lesson set pro_time =?, pro_tel=?" + " where pro_name=?";

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, play.getProName());
			pstmt.setString(2, play.getProTime());
			pstmt.setString(3, play.getProTel());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	// 프로님,시간표 조회
	public List<Lesson> getPlay() {
		List<Lesson> list = new ArrayList<>();
		Lesson lesson = null;
		try {
			conn();
			String sql = "select * from lesson";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				lesson = new Lesson();
				lesson.setProName(rs.getString("pro_name"));
				lesson.setProTime(rs.getString("pro_tiem"));
				lesson.setProTel(rs.getString("pro_tel"));
				lesson.setPga(rs.getString("pga"));
				list.add(lesson);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

}
