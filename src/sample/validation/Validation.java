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
	private static final String VALID_EMAIL_ADDRESS= "kaku@rakus.co.jp";
	
	
	
	// ERROR MESSAGES
	public static final String ERR_MSG_EMPTY_NAME = "名前を入力してください";
	
	
	
	
	private static List<String> errorMessageList = new ArrayList<>();
//	private static Boolean hasError = false;
	
	
	
	public Boolean hasError(){
		return errorMessageList.isEmpty() == false;
	}
	
	public List<String> getErrorMessageList(){
		return errorMessageList;
	}

	/**
	 * 名前の入力値チェック
	 * 
	 * @param user
	 * @return
	 */
	public static String nameCheck(User user) {
		if (user.getName() == null || user.getName().length() == 0) {
			return ERR_MSG_EMPTY_NAME;
		} else if (!(user.getName().equals("賀来"))) {
			return "入力された名前が不正です";
		}
		return null;
	}

	/**
	 * メールアドレスのチェック
	 * 
	 * @param user
	 * @return
	 */
	private final Integer MAIL_MAX_LENGTH = 2;

	public static String emailCheck(User user) {
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			errorMessageList.add("メールアドレスを入力してください");
		} else if (user.getEmail().indexOf("@") == -1 && user.getEmail().indexOf(".") == -1) {
			return "メールアドレスの形式が不正です";
		//正規表現チェック
		} else if (user.getEmail().length() <= 2) {
			return "メールアドレスの値が不正です";
		} else if (!(user.getEmail().equals(VALID_EMAIL_ADDRESS))) {
			return "メールアドレスが違います";
		}
		return null;
	}

	/**
	 * パスワードのチェック
	 * 
	 * @param user
	 * @return
	 */
	public static String passCheck(User user) {

		if (user.getPassword() == null || user.getPassword().length() == 0) {
			return "パスワードを入力してください";
		} else if (user.getPassword().length() < 8 && user.getPassword().length() > 16) {
			return "パスワードは8文字以上16文字以内で入力してください";
		} else if (!(user.getPassword().equals("kakuakane"))) {
			return "パスワードが違います";
		}
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

		return null;
	}
}
