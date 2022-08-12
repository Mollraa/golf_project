package com.golf.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	//JDBC
		// java <-> DB 연결할 떄
		protected Connection conn = null;
		// Select(조회) 결과 값 반환 받는 객체 / DB의 컬럼 low를 모아놓은 걸 자바는 ResultSet이라고 부름
		protected ResultSet rs = null;
		// Query문을 담고 Query문 실행하는 객체
		protected PreparedStatement pstmt = null; // insert 에서 쓰기 편함
		// Query문을 담고 Query문 실행하는 객체
		protected Statement stmt = null; // select 에서 쓰기 편함

		// Referenced Libraries 만들고나서 ↓
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost대신 ip주소가 들어갈수도
		String id = "gini";
		String pw = "12345";

		// 메소드로 연결
		public void conn() {
			try {
				// 1. 드라이버 로딩
				Class.forName(driver);
				// 2. DB 연결
				conn = DriverManager.getConnection(url, id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void disconnect() { // DB열었으면 역순으로 닫아주는거
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

