package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.User;
import com.example.demo.service.InfoChangeService;

import model.InfoChangeForm;

@Controller
@RequestMapping("infoChange")
public class InfoChangeController {
	
	@Autowired
	private InfoChangeService infoChangeService;

	private String SUCCESS_MSG = "ユーザー情報の更新に成功しました。";
	private String FAILURE_MSG = "ユーザー情報の更新に失敗しました。";
	
	/**
	 * リクエストに含まれているidでユーザーを検索する
	 * @param form
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/{id:.+}")
	public String getInit(@ModelAttribute InfoChangeForm form, Model model, @PathVariable("id") int id) {
		
		if(id > 0) {
			User user = infoChangeService.selectOne(id);
			form.setId(user.getId());
			form.setUserName(user.getName());
			form.setEmail(user.getEmail());
		}
		
		model.addAttribute("infoChangeForm", form);
		
		return "infoChange/infoChange";
	}
	
	/**
	 * ユーザー情報変更
	 * @param form
	 * @param model
	 * @return
	 */
	@PostMapping("/change")
	public String infoChange(InfoChangeForm form, Model model) {
		
		//引数の準備
		User user = new User();
		user.setId(form.getId());
		user.setName(form.getUserName());
		user.setEmail(form.getEmail());
		
		/* ユーザー情報更新の実行 */
		boolean result = infoChangeService.updateOne(user);
		
		//処理結果を画面に表示させる
		if(result) {
			model.addAttribute("msg", SUCCESS_MSG);
		} else {
			model.addAttribute("msg", FAILURE_MSG);
		}
		
		return "infoChange/infoChange";
	}

}
