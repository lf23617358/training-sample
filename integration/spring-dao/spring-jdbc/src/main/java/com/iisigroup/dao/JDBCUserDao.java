package com.iisigroup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.iisigroup.domain.User;

@Repository
@Transactional
public class JDBCUserDao implements UserDao {
	private JdbcTemplate jdbcTemplate;
	private static final String FIND_ALL_STMT = "SELECT * FROM USER";
	private static final String FIND_BY_PK_STMT = "SELECT * FROM USER WHERE id = ?";
	private static final String INSERT_STMT = "INSERT INTO USER (id,name,age) VALUES (?,?,?)";
	private static final String UPDATE_STMT = "UPDATE USER SET name = ?,age = ? WHERE id = ?";
	private static final String DELETE_STMT = "DELETE FROM USER WHERE id = ?";

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(User po) {
		jdbcTemplate.update(INSERT_STMT, po.getId(), po.getName(), po.getAge());
	}

	@Override
	public void update(User po) {
		jdbcTemplate.update(UPDATE_STMT, po.getName(), po.getAge(), po.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update(DELETE_STMT, id);
	}

	@Transactional(readOnly = true)
	@Override
	public User findByPrimary(Long id) {
		List<User> users = jdbcTemplate.query(FIND_BY_PK_STMT, new Object[] { id }, userRowMapper);
		return CollectionUtils.isEmpty(users) ? null : users.get(0);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		return jdbcTemplate.query(FIND_ALL_STMT, userRowMapper);
	}

	private RowMapper<User> userRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			return user;
		}
	};

}
