package com.hello.hellospring.dao;

import com.hello.hellospring.model.User;


public interface UserDao{

	User findByUserName(String username);

}