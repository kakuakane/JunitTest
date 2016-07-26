package sample.validation;

import sample.common.User;

/**
 * 入力値を定義するクラス.
 * 
 * @author akane.kaku
 *
 */
public class InputValue {
	
	/**正常なユーザー */
	public static final User RIGHT_USER = new User("賀来","kaku@rakus.co.jp","kakuakane");
	
	/**名前が一致しないユーザー */
	public static final User NOT_MATCH_NAME = new User("aaa","kaku@rakus.co.jp","kakuakane");
	/**名前が空文字のユーザー	 */
	public static final User EMPTY_NAME = new User("","kaku@rakus.co.jp","kakuakane");
	/**名前がnullのユーザー */
	public static final User NULL_NAME = new User(null,"kaku@rakus.co.jp","kakuakane");
	
	/**メールアドレスが一致しないユーザー	 */
	public static final User NOT_MATCH_EMAIL = new User("賀来","aaa@rakus.co.jp","kakuakane");
	/**メールアドレスが空文字のユーザー */
	public static final User EMPTY_EMAIL = new User("賀来","","kakuakane");
	/**メールアドレスがnullのユーザー */
	public static final User NULL_EMAIL = new User("賀来",null,"kakuakane");
	/**メールアドレスの形式が不正のユーザー　今回は未使用 */
	public static final User INVALID_TYPE_EMAIL = new User("賀来","kaku@rakus","kakuakane");
	/**メールアドレスが不正のユーザー　今回は未使用 */
	public static final User INVALID_EMAIL = new User("賀来","@.","kakuakane");
	
	/**パスワードが一致しないユーザー */
	public static final User NOT_MATCH_PASSWORD = new User("賀来","kaku@rakus.co.jp","aaaaaaaaa");
	/**パスワードが空文字のユーザー */
	public static final User EMPTY_PASSWORD = new User("賀来","kaku@rakus.co.jp","");
	/**パスワードがnullのユーザー */
	public static final User NULL_PASSWORD = new User("賀来","kaku@rakus.co.jp",null);
	/**パスワードが指定した文字数より短いユーザー */
	public static final User TOO_SHORT_PASSWORD = new User("賀来","kaku@rakus.co.jp","asdfghj");
	/**パスワードが指定した文字数より長いユーザー */
	public static final User TOO_LONG_PASSWORD = new User("賀来","kaku@rakus.co.jp","asdfghjklasdfghjkl");
	
//	public static final String notMatchNameError = "入力された名前が不正です";
//	public static final String notInputNameError = Validation.ERR_MSG_EMPTY_NAME;
//	public static final String notMatchEmailError = "メールアドレスが違います";
//	public static final String notInputEmailError = "メールアドレスを入力してください";
//	public static final String invalidTypeEmailError = "メールアドレスの形式が不正です";
//	public static final String invalidEmailError = "メールアドレスの値が不正です";
//	
//	public static final String notInputPasswordError = "パスワードを入力してください";
//	public static final String invalidLengthPasswordError = "パスワードは8文字以上16文字以内で入力してください";
//	public static final String notMatchPasswordError = "パスワードの値が不正です";
	
//	public static User getRightuser() {
//		return rightUser;
//	}
//	public static User getNotmatchname() {
//		return notMatchName;
//	}
//	public static User getEmptyname() {
//		return emptyName;
//	}
//	public static User getNullname() {
//		return nullName;
//	}
//	public static User getNotmatchemail() {
//		return notMatchEmail;
//	}
//	public static User getEmptyemail() {
//		return emptyEmail;
//	}
//	public static User getNullemail() {
//		return nullEmail;
//	}
//	public static User getInvalidtypeemail() {
//		return invalidTypeEmail;
//	}
//	public static User getInvalidemail() {
//		return invalidEmail;
//	}
//	public static User getNotmatchpassword() {
//		return notMatchPassword;
//	}
//	public static User getEmptypassword() {
//		return emptyPassword;
//	}
//	public static User getNullpassword() {
//		return nullPassword;
//	}
//	public static User getTooshortpassword() {
//		return tooShortPassword;
//	}
//	public static User getToolongpassword() {
//		return toolongPassword;
//	}
//	
//	public static String getNotmatchnameerror() {
//		return notMatchNameError;
//	}
//	public static String getNotinputnameerror() {
//		return notInputNameError;
//	}
//	public static String getNotmatchemailerror() {
//		return notMatchEmailError;
//	}
//	public static String getNotinputemailerror() {
//		return notInputEmailError;
//	}
//	public static String getInvalidtypeemailerror() {
//		return invalidTypeEmailError;
//	}
//	public static String getInvalidemailerror() {
//		return invalidEmailError;
//	}
//	public static String getNotinputpassworderror() {
//		return notInputPasswordError;
//	}
//	public static String getInvalidlengthpassworderror() {
//		return invalidLengthPasswordError;
//	}
//	public static String getNotmatchpassworderror() {
//		return notMatchPasswordError;
//	}
}


	