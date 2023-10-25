package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.data.User;

@Component
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * ユーザー全件検索するメソッド
	 * @return
	 */
	public List<Map<String, Object>> searchAll() {
		//SQL
		String query = "SELECT * FROM user";
		
		//SQL実行
		List<Map<String, Object>> list = jdbc.queryForList(query);
		
		//実行結果をリターンする
		return list;
	}
	
	/**
	 * ユーザーテーブルに１件追加するメソッド
	 * @param user
	 * @return
	 */
	public int insertOne(User user) {
		
		int rowNumber = jdbc.update("INSERT INTO user(name, email) "
				 + "VALUES(?, ?)", user.getName(), user.getEmail());
		
		return rowNumber;
	}

}
