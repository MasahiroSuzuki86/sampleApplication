package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.data.User;

/**
 * ユーザー検索サービスクラス
 * @author suzukimasahiro
 *
 */
@Service
public class UserSearchService {
	
	/** DBアクセス用のクラス */
	@Autowired
	private UserDao dao;
	
	public List<User> searchAll() {
		
		/** DB検索 */
		List<Map<String, Object>> result = dao.searchAll();
		
		return getUserList(result);
	}
	
	/**
	 * 検索結果をユーザークラスのリスト形式に変換する
	 * @param result
	 * @return
	 */
	private List<User> getUserList(List<Map<String, Object>> result) {
		
		//戻り値用のリスト
		List<User> userList = new ArrayList<User>();
		
		//検索結果をUserクラスに格納する
		for(int i = 0; i < result.size(); i++) {
			int id = (Integer)result.get(i).get("id");
			String name = (String)result.get(i).get("name");
			String email = (String)result.get(i).get("email");
			
			//検索結果をインスタンスにセットする
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			
			//戻り値用のリストに格納
			userList.add(user);
		}
		
		return userList;
	}

}
