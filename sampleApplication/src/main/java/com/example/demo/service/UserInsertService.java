package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.data.User;

/**
 * ユーザーテーブル更新用サービス
 * @author suzukimasahiro
 *
 */
@Service
public class UserInsertService {
	
	/*　ユーザーテーブル接続用のDao */
	@Autowired
	private UserDao dao;
	
	/**
	 * ユーザーテーブル１件追加用メソッド
	 * @param user
	 * @return
	 */
	public boolean insert(User user) {
		
		int rowNumber = dao.insertOne(user);
		
		boolean result = false;
		
		/* 更新した行数が1行以上の場合成功 */
		if(rowNumber > 0) {
			result = true;
		}
		
		return result;
		
	}

}
