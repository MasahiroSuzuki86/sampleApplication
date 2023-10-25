package model;

import lombok.Data;

/**
 * ユーザー情報変更画面に入力した情報を受け取るクラス
 * @author suzukimasahiro
 *
 */
@Data
public class InfoChangeForm {
	
	/* ID */
	private int id;
	
	/* ユーザー名 */
	private String userName;
	
	/* メールアドレス */
	private String email;

}
