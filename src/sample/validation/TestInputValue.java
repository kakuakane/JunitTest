package sample.validation;

import sample.common.User;

/**
 * テストで入力する値を定義するクラス.
 * 
 * @author akane.kaku
 *
 */
public class TestInputValue {
	
	public static final User RIGHT_USER = new User("賀来","kaku@rakus.co.jp","kakuakane");
	
	public static final User notMatchName = new User("aaa","kaku@rakus.co.jp","kakuakane");
	public static final User emptyName = new User("","kaku@rakus.co.jp","kakuakane");
	public static final User nullName = new User(null,"kaku@rakus.co.jp","kakuakane");
	
	public static final User notMatchEmail = new User("賀来","aaa@rakus.co.jp","kakuakane");
	public static final User emptyEmail = new User("賀来","","kakuakane");
	public static final User nullEmail = new User("賀来",null,"kakuakane");
	public static final User invalidTypeEmail = new User("賀来","kaku@rakus","kakuakane");
	public static final User invalidEmail = new User("賀来","@.","kakuakane");
	
	public static final User notMatchPassword = new User("賀来","kaku@rakus.co.jp","aaaaaaaaa");
	public static final User emptyPassword = new User("賀来","kaku@rakus.co.jp","");
	public static final User nullPassword = new User("賀来","kaku@rakus.co.jp",null);
	public static final User tooShortPassword = new User("賀来","kaku@rakus.co.jp","kak");
	public static final User toolongPassword = new User("賀来","kaku@rakus.co.jp","asdfghjklasdfghjkl");
	
	public static final String notMatchNameError = "入力された名前が不正です";
	public static final String notInputNameError = Validation.ERR_MSG_EMPTY_NAME;
	public static final String notMatchEmailError = "メールアドレスが違います";
	public static final String notInputEmailError = "メールアドレスを入力してください";
	public static final String invalidTypeEmailError = "メールアドレスの形式が不正です";
	public static final String invalidEmailError = "メールアドレスの値が不正です";
	
	public static final String notInputPasswordError = "パスワードを入力してください";
	public static final String invalidLengthPasswordError = "パスワードは8文字以上16文字以内で入力してください";
	public static final String notMatchPasswordError = "パスワードの値が不正です";
	
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


	