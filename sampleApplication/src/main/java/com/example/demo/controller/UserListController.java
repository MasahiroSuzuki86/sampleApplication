package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.User;
import com.example.demo.service.UserSearchService;

@Controller
@RequestMapping("/userList")
public class UserListController {
	
	/** ユーザー検索サービス */
	@Autowired
	private UserSearchService userSearchService;
	
	/**
	 * Get 通信を処理するメソッド
	 * http:localhost:8080/userList/initを処理する
	 * @param model
	 * @return
	 */
	@GetMapping("/init")
	public String getUserList(Model model) {
		
		//ユーザー全件検索
		List<User> userList = userSearchService.searchAll();
		model.addAttribute("userList", userList);
		
		return "userList/userList";
	}

}
