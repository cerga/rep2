package com.hxy.jdbctemplate;

import java.util.List;

import com.hxy.bean.User;
import com.hxy.dao.UserDao;
import com.hxy.dao.UserDaoImpl;

public class Demo01JdbcTemplate {
	public static void main(String[] args) {
		// 通过 当前调用方法
		UserDao ud = new UserDaoImpl();
		List<User> list = ud.findAllUser();
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}
