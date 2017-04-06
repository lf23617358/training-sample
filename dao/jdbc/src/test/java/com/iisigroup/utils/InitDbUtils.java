package com.iisigroup.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDbUtils {
	private static final String DROP_USER = "DROP TABLE USER IF EXISTS";
	private static final String CREATE_USER = "CREATE TABLE USER (id bigint not null, name varchar(255), age number, primary key (id))";
	private static final String INSERT_USER = "INSERT INTO USER (id, name, age) values (?,?,?)";

	public static void initDDL() {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		Statement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE", "sa", "");
			pstmt = con.createStatement();
			pstmt.executeUpdate(DROP_USER);
			pstmt.executeUpdate(CREATE_USER);
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void initDML() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE", "sa", "");

			pstmt = con.prepareStatement(INSERT_USER);
			pstmt.setLong(1, 1l);
			pstmt.setString(2, "testuser1");
			pstmt.setInt(3, 18);
			pstmt.addBatch();

			pstmt.setLong(1, 2l);
			pstmt.setString(2, "testuser2");
			pstmt.setInt(3, 22);
			pstmt.addBatch();

			pstmt.executeBatch();
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
