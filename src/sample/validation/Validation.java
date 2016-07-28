package sample.validation;

import java.util.ArrayList;
import java.util.List;

import sample.common.User;

/**
 * 入力値チェック.
 * 
 * @author akane.kaku
 *
 */
public class Validation {
	// VALID PROPERTY
	private static final String VALID_NAME = "賀来";
	private static final String VALID_EMAIL = "kaku@rakus.co.jp";
	private static final String VALID_PASSWORD = "kakuakane";

	// ERROR MESSAGES
	public static final String ERR_MSG_EMPTY_NAME = "名前を入力してください";
	public static final String ERR_MSG_INVALID_NAME = "名前が不正です";
	public static final String ERR_MSG_INVALID_EMAIL = "メールアドレスが不正です";
	public static final String ERR_MSG_EMPTY_EMAIL = "メールアドレスを入力してください";
	public static final String ERR_MSG_INVALID_PASSWORD = "パスワードが不正です";
	public static final String ERR_MSG_EMPTY_PASSWORD = "パスワードを入力してください";

	public static List<String> errorMessageList = new ArrayList<>();
	// private static Boolean hasError = false;

	/**
	 * エラーがあるかを判断する.
	 * @return エラーがなければfalseを返す
	 */
	public static Boolean hasError() {
		return errorMessageList.isEmpty() == false;
	}

	/**
	 * エラーメッセージを返す.
	 * @return エラーメッセージ
	 */
	public static List<String> getErrorMessageList() {
		return errorMessageList;
	}
	
	public static void listReset(){
		errorMessageList.clear();
	}
	/**
	 * 名前の入力チェック
	 * 
	 * @param user
	 */
	public static void nameCheck(User user) {
		//empty or null
		
		//length
		
		//format(全角)
		
		//multiple(?)
		
		//valid
		
		
		if (user.getName() == null || user.getName().length() == 0) {
			errorMessageList.add(ERR_MSG_EMPTY_NAME);
		} else if (!(user.getName().equals(VALID_NAME))) {
			errorMessageList.add(ERR_MSG_INVALID_NAME);
		}
	}

	/**
	 * メールアドレスの入力チェック
	 * 
	 * @param user
	 */

	public static void emailCheck(User user) {
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			errorMessageList.add(ERR_MSG_EMPTY_EMAIL);
		} else if (!(user.getEmail().equals(VALID_EMAIL))) {
			errorMessageList.add(ERR_MSG_INVALID_EMAIL);
		}
		// 正規表現チェック

		// private final Integer MAIL_MAX_LENGTH = 2;
		// } else if (user.getEmail().indexOf("@") == -1 &&
		// user.getEmail().indexOf(".") == -1) {
		// return "メールアドレスの形式が不正です";
		// } else if (user.getEmail().length() <= 2) {
		// return "メールアドレスの値が不正です";
		// }
		// return null;
	}

	/**
	 * パスワードの入力チェック
	 * 
	 * @param user
	 */
	public static void passCheck(User user) {
		if (user.getPassword() == null || user.getPassword().length() == 0) {
			errorMessageList.add(ERR_MSG_EMPTY_PASSWORD);
		} else if (!(user.getPassword().equals(VALID_PASSWORD))) {
			errorMessageList.add(ERR_MSG_INVALID_PASSWORD);
		}
		// } else if (user.getPassword().length() < 8 &&
		// user.getPassword().length() > 16) {
		// return "パスワードは8文字以上16文字以内で入力してください";
		// TODO:パスワードのセキュリティ強化.半角英数字記号を含める

		// for (char temp : user.getPassword().toCharArray()) {
		// if (!(temp >= '!' && temp <= '~')) {
		// if (temp >= 'A' && temp <= 'Z') {
		// check = false;
		// } else if (!(temp >= 'a' && temp <= 'z')) {
		// check = true;
		// } else if (!(temp >= '0' && temp <= '9')) {
		// check = false;
		// }
	}
}
