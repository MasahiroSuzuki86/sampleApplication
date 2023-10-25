package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.User;
import com.example.demo.service.UserInsertService;

import model.UserInsertForm;

@Controller
@RequestMapping("userInsert")
public class UserInsertController {
	
	/** ユーザー追加サービス */
	@Autowired
	private UserInsertService userInsertService;
	
	private String SUCCESS_MSG = "ユーザー追加に成功しました。";
	private String FAILURE_MSG = "ユーザー追加に失敗しました。";
	
	/**
	 * ユーザー追加画面初期表示用メソッド
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/init")
	public String init(Model model, UserInsertForm form) {
		
		return "userInsert/userInsert";
	}
	
	/**
	 * 画面に入力したデータでユーザー情報を追加する
	 * @param model
	 * @param form
	 * @return
	 */
	@PostMapping("/insert")
	public String insert(Model model, UserInsertForm form) {
		
		User user = new User();
		user.setName(form.getUserName());
		user.setEmail(form.getEmail());
		
		/* ユーザー追加処理の実行 */
		boolean result = userInsertService.insert(user);
		
		//処理結果を画面に表示させる
		if(result) {
			model.addAttribute("msg", SUCCESS_MSG);
			//フォームの初期化
			form = new UserInsertForm();
		} else {
			model.addAttribute("msg", FAILURE_MSG);
		}
		
		return "userInsert/userInsert";
	}

}
