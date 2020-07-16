package com.hxy.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hxy.bean.User;
import com.hxy.druid.JDBCUtils;

public class UserDaoImpl implements UserDao {
	
	// 创建 jdbctempalte 对象
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public List<User> findAllUser() {
		String sql = " select * from t_user ";
		List<User> lsit = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return lsit;
	}
	
}
