package model;

import lombok.Data;

/**
 * ユーザー追加画面に入力した情報を受け取るクラス
 * @author suzukimasahiro
 *
 */
@Data
public class UserInsertForm {
	
	/*　ユーザー名 */
	private String userName;
	
	/* メールアドレス */
	private String email;

}
