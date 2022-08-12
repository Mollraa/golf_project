package com.golf.member;

import java.util.ArrayList;
import java.util.List;
import com.golf.common.DAO;
import com.golf.lesson.Lesson;

public class MemberManage extends DAO {

	private static MemberManage mm = new MemberManage();

	private MemberManage() {

	}

	public static MemberManage getInstance() {
		return mm;
	}
//1.회원등록 2.회원수정 3.회원조회(전체) 4. 회원조회(단건) , 5. 프로정보조회, 6.스캐쥴변경, 7.회원삭제, 8. 매출, 9.종료

//회원 -> 1. 나의 정보 조회 | 2. 시간 조회 / 변경? | 3.종료 

//로그인 
//	- 로그인 (매소드) 조회해서 있으면 로그인 성공 
	public Member loginInfo(String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * FROM member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setRole(rs.getString("role"));
				member.setProName(rs.getString("pro_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

//	로그아웃
//	public void logout() {
//		if (memberInfo != null)
//			memebrInfo = null;
//	}

//1.회원등록
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
	public int registCustomer(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member (member_id , member_pw,"
					+ "member_name, member_tel, member_addr, day_start,"
					+ "day_end, pay_lesson, pay_prac, role, pro_name) values (?,?,?,?,?,?,ADD_MONTHS(sysdate, ?),?,?,?,?)";// member_role
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddr());
			pstmt.setString(6, member.getDayStart());
			pstmt.setString(7, member.getDayEnd());
			pstmt.setInt(8, member.getPayLesson());
			pstmt.setInt(9, member.getPayPrac());
			pstmt.setString(10, member.getRole());
			pstmt.setString(11, member.getProName());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	2.회원수정
	public int updateCustomer(Member member) {
		int result = 0;
		try {
			conn();
			// UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]
			String sql = "update member set member_name =?, member_tel=?, member_addr=? where member_id=?";

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberTel());
			pstmt.setString(3, member.getMemberAddr());
			pstmt.setString(4, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;

	}

	
	
//	3.회원조회(전체) 
	public List<Member> getDetailMember(String memberId) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select member_id , member_pw, member_name, member_tel, member_addr, day_start, day_end, pay_lesson, pay_prac, role, pro_name from member ";// member_role
			
			//values (?,?,?,?,?,?,ADD_MONTHS(sysdate, ?),?,?,?,?)
			
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, member.getMemberId());
//			pstmt.setString(2, member.getMemberPw());
//			pstmt.setString(3, member.getMemberName());
//			pstmt.setString(4, member.getMemberTel());
//			pstmt.setString(5, member.getMemberAddr());
//			pstmt.setString(6, member.getDayStart());
//			pstmt.setString(7, member.getDayEnd());
//			pstmt.setInt(8, member.getPayLesson());
//			pstmt.setInt(9, member.getPayPrac());
//			pstmt.setString(10, member.getRole());
//			pstmt.setString(11, member.getProName());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
//				MEMBER_ID   NOT NULL VARCHAR2(20)  
//				MEMBER_PW   NOT NULL VARCHAR2(20)  
//				MEMBER_NAME NOT NULL VARCHAR2(20)  
//				MEMBER_TEL  NOT NULL VARCHAR2(20)  
//				MEMBER_ADDR          VARCHAR2(200) 
//				DAY_START            DATE          
//				DAY_END              DATE          
//				PAY_LESSON           NUMBER        
//				PAY_PRAC             NUMBER        
//				ROLE                 CHAR(1)  
//				PRO_NAME             VARCHAR2(20)  
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getNString("member_name"));
				member.setMemberTel(rs.getNString("member_tel"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setDayStart(rs.getString("day_start"));
				member.setDayEnd(rs.getString("day_end"));
				member.setPayLesson(rs.getInt("pay_lesson"));
				member.setPayPrac(rs.getInt("pay_prac"));
				member.setProName(rs.getString("pro_name"));
				//member.setRole(rs.get );
				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

//	4. 회원조회(단건) => id name tel addr start end 
	public Member getmemBer(String memberId) {
		Member mem = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id")); // id
				mem.setMemberName(rs.getString("member_name")); // 이름pstmt.setString(4, member.getMemberTel());
				mem.setMemberTel(rs.getString("member_tel"));
				mem.setMemberAddr(rs.getString("member_addr"));
				mem.setDayStart(rs.getString("day_start"));
				mem.setDayEnd(rs.getString("day_end"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mem;
	}

//, 5. 프로정보조회(lessonManage)
	
// 6.회원삭제
	public int deleteMember(String memberId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from member where member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return result;
	}

//7. 매출
	public List<Member> getPay(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT to_char(day_start, 'yyyy/mm') as 'start' ,sum(pay_lesson) as 'lesson' ,"
					+ "sum(pay_prac) as 'prac' from member"
					+ "WHERE day_start is not null"
					+ "group by to_char(day_start, 'yyyy/mm')";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				member = new Member();
				member.setDayStart(rs.getString("start"));
				member.setPayLesson(rs.getInt("lesson"));
				member.setPayPrac(rs.getInt("prac"));
				list.add(member);
				}
							
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}		
		return list;
	}


// 회원 -> 1. 나의 정보 조회
	public List<Member> getDetailMyinfo(String memberId) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select member_id,member_name,member_tel,member_addr \"\r\n"
					+ "					+\",to_char(day_start,'yyyy/mm/dd') day_start,to_char(day_end,'yyyy/mm/dd') day_end\" \r\n"
					+ "					+ \", from member where member_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setDayStart(rs.getString("day_start"));
				member.setDayEnd(rs.getNString("day_end"));

				//pstmt.setString(10, member.getRole());
				list.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}


}
