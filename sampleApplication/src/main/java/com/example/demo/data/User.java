package com.example.demo.data;

import lombok.Data;

/**
 * Userテーブル１行分のデータを管理するクラス
 * @author suzukimasahiro
 *
 */
//@Dataとつけることでゲッターとセッターを省略できる(Springのlombokというライブラリ)
@Data
public class User {
	
	private int id;
	private String name;
	private String email;

}
