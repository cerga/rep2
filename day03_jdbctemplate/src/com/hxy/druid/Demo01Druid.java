package com.hxy.druid;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Demo01Druid {
	public static void main(String[] args) throws Exception {
		// 导入包 练习到10.05 10.25收取课堂练习
		// 定义配置文件
		// 加载配置文件
		Properties pro = new Properties();
		// 加载器
		InputStream resourceAsStream = Demo01Druid.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// load 
		pro.load(resourceAsStream);
		
		String property = pro.getProperty("name");
		String password = pro.getProperty("password");
		System.out.println(password);
		System.out.println(property);
		
		// 数据库连接池对象
//		DruidDataSourceFactory 
		DataSource datasource = DruidDataSourceFactory.createDataSource(pro);
		// 数据库连接
		System.out.println(datasource.getConnection());
		
		//获取连接
		Connection connection = datasource.getConnection();
		
		System.out.println("获取的连接"+connection);
		// 执行sql对象
		Statement createStatement =connection.createStatement();
		
		// 声明sql
		String sql = " select * from t_user  ";
		
		// 执行查询
		ResultSet rs= createStatement.executeQuery(sql);
		
		// 遍历结果
		while (rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			Integer age = rs.getInt("age");
			System.out.println(name+address+age);
		}
		//归还连接
		connection.close();
		
	
	}
}
