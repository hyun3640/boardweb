package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩과 연결 설정 관련 오류");
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ResultSet 관련 에러");
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ResultSet 관련 에러");
			} finally {
				conn = null;
			}
		}

	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("ResultSet 관련 에러");
			} finally {
				rs = null;
			}
		}
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ResultSet 관련 에러");
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ResultSet 관련 에러");
			} finally {
				conn = null;
			}
		}
	}

}
