package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.data.User;

@Service
public class InfoChangeService {
	
	@Autowired
	private UserDao dao;
	
	/**
	 * ユーザーを一件検索
	 * @param id
	 * @return
	 */
	public User selectOne(int id) {
		
		User user = dao.searchOne(id);
		
		return user;
	}

	/**
	 * ユーザー情報変更
	 * @param user
	 * @return
	 */
	public boolean updateOne(User user) {
		
		int rowNumber = dao.updateOne(user);
		
		boolean result = false;
		
		if(rowNumber > 0) {
			result = true;
		}
		
		return result;
	}
}
