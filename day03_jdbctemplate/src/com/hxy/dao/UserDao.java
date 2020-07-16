package com.hxy.dao;

import java.util.List;
import com.hxy.bean.User;

public interface UserDao {
	// 查询 所有
	List<User> findAllUser();
	// 查询一个 user对象
	
}
