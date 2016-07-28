package sample.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sample.common.User;

/**
 * 入力値チェック.
 * 
 * @author akane.kaku
 *
 */
/**
 * @author rks_user
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
	public static final String ERR_MSG_REJEX_EMAIL = "メールアドレスの形式が不正です";
	
public static final String ERR_MSG_INVALID_PASSWORD = "パスワードが不正です";
	public static final String ERR_MSG_EMPTY_PASSWORD = "パスワードを入力してください";
	public static final String ERR_MSG_REJEX_PASSWORD ="パスワードは半角英数字記号すべて含めてください";

	public static List<String> errorMessageList = new ArrayList<>();
	// private static Boolean hasError = false;

	/**
	 * エラーがあるかを判断する
	 * 
	 * @return エラーがなければfalseを返す
	 */
	public static Boolean hasError() {
		return errorMessageList.isEmpty() == false;
	}

	/**
	 * エラーメッセージを返す
	 * 
	 * @return エラーメッセージ
	 */
	public static List<String> getErrorMessageList() {
		return errorMessageList;
	}

	/**
	 * リストの中身を空にする
	 */
	public static void listReset() {
		errorMessageList.clear();
	}

	/**
	 * 名前の入力チェック
	 * 
	 * @param user
	 */
	public static void nameCheck(User user) {
		if (user.getName() == null || user.getName().length() == 0) {
			errorMessageList.add(ERR_MSG_EMPTY_NAME);
			// valid
		} else if (!(user.getName().equals(VALID_NAME))) {
			errorMessageList.add(ERR_MSG_INVALID_NAME);
			// length
		} else if (user.getName().length() > 10) {
			errorMessageList.add("e");
			// multiple(?)
		}

		// format(全角)

	}

	/**
	 * メールアドレスの入力チェック
	 * 
	 * @param user
	 */

	public static void emailCheck(User user) {
		// empty or null
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			errorMessageList.add(ERR_MSG_EMPTY_EMAIL);
			// valid
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
	}
		// } else if (user.getPassword().length() < 8 &&
		// user.getPassword().length() > 16) {
		// return "パスワードは8文字以上16文字以内で入力してください";

	/**
	 * パスワードの正規表現
	 * パスワードのセキュリティ強化.半角英数字記号を含める
	 * @param user
	 */
	public static void regexPass(User user) {
//		パスワードのセキュリティ強化.半角英数字記号を含める
		Pattern p = Pattern.compile("(?!^[^0-9]*$)(?!^[^a-z]*$)(?!^[^A-Z]*$)(?!^[^-_.]*$)^([a-zA-Z0-9-_-]+)$");
		Matcher m = p.matcher(user.getPassword());
		if (!(m.find())) {
			errorMessageList.add(ERR_MSG_REJEX_PASSWORD);
		}
	}
	
	/**
	 * メールアドレスの正規表現
	 * @param user
	 */
	public static void regexEmail(User user){
		Pattern p = Pattern.compile("[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+");
		Matcher m = p.matcher(user.getEmail());
		if (!(m.find())) {
			errorMessageList.add(ERR_MSG_REJEX_EMAIL);
		}
	}
}
