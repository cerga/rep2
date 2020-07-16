package com.hxy.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hxy.bean.User;
import com.hxy.dao.UserDao;
import com.hxy.dao.UserDaoImpl;
import com.hxy.druid.JDBCUtils;

public class Demo01JdbcTemplate2 {
	

	
	public static void main(String[] args) {
		// 调用 方法  Alt + shift + M 抽取方法 
//		findAllUser();
		
		//添加
//		addUser1();
		
		//修改
//		updateUser();
		
		//删除
//		deleteUser();
		
		//查询记录数
//		count();
		
		//查询单个实体
		findUserById();
	}
	//查询单个实体 预编译
	private static void findUserById1() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update 
//		jt.queryForObject(sql, requiredType, args)
		List<User> list =  jt.query(" select * from t_user where id = ? ", new BeanPropertyRowMapper(User.class), 3);
		User user2 = list.get(0);
		System.out.println(user2);
		System.out.println(list);
		
		
	}
	
	//查询单个实体 预编译
	private static void findUserById() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update 
//		jt.queryForObject(sql, requiredType, args)
		User user = jt.queryForObject(" select * from t_user where id = ?  ", new BeanPropertyRowMapper<>(User.class),3);
		
		System.out.println(user);
		
	}
	
	
	//删除方法 预编译
	private static void count() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update
		Long count = jt.queryForObject(" select count(1) from t_user ", Long.class);
		System.out.println(count);
		
	}
	
	//删除方法 预编译
	private static void deleteUser() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update
		int update = jt.update(" delete from t_user where id = ? ",4 );
		System.out.println(update);
		
	}
	
	
	//修改方法 预编译
	private static void updateUser() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update
		int update = jt.update(" update t_user set name = ? ,age = ? , address=?  where id = ? ", "奥巴马1号",45,"美国",3 );
		System.out.println(update);
		
	}
	
	//添加方法 预编译
	private static void addUser1() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update
		String sql = " insert into t_user(name,age,address) values (?,?,?) ";
		int update = jt.update(sql,"蓬佩奥",70,"美国");
		System.out.println(update);
		
	}
	
	//添加方法
	private static void addUser() {
		//添加sql
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		//update
		String sql = " insert into t_user(name,age,address) values ('特朗普1号',18,'白宫') ";
		int update = jt.update(sql);
		System.out.println(update);
		
	}

	private static void findAllUser() {
		//查询
		JdbcTemplate jt =new JdbcTemplate(JDBCUtils.getDataSource());
		
		String sql = " select * from t_user";
		List<User> list = jt.query(sql, new BeanPropertyRowMapper(User.class));
//		List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
		
		for (User user : list) {
			System.out.println(user);
		}
	}
}
