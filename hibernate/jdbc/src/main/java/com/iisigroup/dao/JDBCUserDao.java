package com.iisigroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iisigroup.domain.User;

public class JDBCUserDao implements UserDao {
	private static String DB_URL = "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE";
	private static String DB_USERNAME = "sa";
	private static String DB_PASSWORD = "";
	private static final String FIND_ALL_STMT = "SELECT * FROM USER";
	private static final String FIND_BY_PK_STMT = "SELECT * FROM USER WHERE id = ?";
	private static final String INSERT_STMT = "INSERT INTO USER (id,name,age) VALUES (?,?,?)";
	private static final String UPDATE_STMT = "UPDATE USER SET name = ?,age = ? WHERE id = ?";
	private static final String DELETE_STMT = "DELETE FROM USER WHERE id = ?";

	@Override
	public void insert(User po) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setLong(1, po.getId());
			pstmt.setString(2, po.getName());
			pstmt.setInt(3, po.getAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(User po) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setString(1, po.getName());
			pstmt.setInt(2, po.getAge());
			pstmt.setLong(3, po.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(Long id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public User findByPrimary(Long id) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK_STMT);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			pstmt = con.prepareStatement(FIND_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				users.add(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException("database error" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return users;
	}

}
