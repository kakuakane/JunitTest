package sample.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import sample.common.User;
import org.junit.runner.RunWith;
import static sample.validation.TestInputValue.*;

/***
 * Userの検証を行う。
 * 正常系のテスト：Userのプロパティが、下記の条件をすべて満たす。
 * ・nameが_文字以上_文字以内で、漢字であること。
 *
 * 異常系のテスト：Userのプロパティが下記の場合を検証し、適切なエラーメッセージを返す。
 * 検証値については{@link TestInputValue}を参照
 * 
 * 例）
 * 検証値												期待値
 *  new User("賀来","kaku@rakus.co.jp","aaaaaaaaa")	パスワードの値が不正です
 *  
 * @author rks_user
 *
 */
@RunWith(Enclosed.class)
public class ValidationTest {
	public static class 値が正しいとき {

		@Test
		public void 名前に正しい値を入力して正しい結果が返る() {
			String actual = Validation.nameCheck(RIGHT_USER);
			assertThat(actual, is(nullValue()));
		}

		@Test
		public void メールアドレスに正しい値を入力して正しい結果が返る() {
			String actual = Validation.emailCheck(RIGHT_USER);
			assertThat(actual, is(nullValue()));
		}

		@Test
		public void パスワードに正しい値を入力して正しい結果が返る() {
			String actual = Validation.passCheck(RIGHT_USER);
			assertThat(actual, is(nullValue()));
		}
	}

	// @RunWith(Theories.class)
	public static class 名前が不正なとき {
		private User NOT_MATCH_NAME = TestInputValue.notMatchName;
		private User EMPTY_NAME = TestInputValue.emptyName;
		private User NULL_NAME = TestInputValue.nullName;

		@Test
		public void 名前に不正な値を入力してエラーが返る() {
			String NOT_MATCH_MESSAGE = TestInputValue.notMatchNameError;
			String actual = Validation.nameCheck(NOT_MATCH_NAME);
			assertThat(actual, is(NOT_MATCH_MESSAGE));
		}

		@Test
		public void 名前が空文字でエラーが返る() {
			String NOT_INPUT_MESSAGE = TestInputValue.notInputNameError;
			String actual = Validation.nameCheck(EMPTY_NAME);
			assertThat(actual, is(NOT_INPUT_MESSAGE));
		}

		@Test
		public void 名前が未入力でエラーが返る() {
			String actual = Validation.nameCheck(NULL_NAME);
			assertThat(actual, is(Validation.ERR_MSG_EMPTY_NAME));
		}
	}

	public static class メールアドレスが不正なとき {
		private User NOT_MATCH_EMAIL = TestInputValue.notMatchEmail;
		private User EMPTY_EMAIL = TestInputValue.emptyEmail;
		private User NULL_EMAIL = TestInputValue.nullEmail;
		private User INVALID_TYPE_EMAIL = TestInputValue.invalidTypeEmail;
		private User INVALID_EMAIL = TestInputValue.invalidEmail;

		@Test
		public void メールアドレスに異なる値を入力してエラーが返る() {
			String NOT_MATCH_MESSAGE = TestInputValue.notMatchEmailError;
			String actual = Validation.emailCheck(NOT_MATCH_EMAIL);
			assertThat(actual, is(NOT_MATCH_MESSAGE));
		}

		@Test
		public void メールアドレスが空文字でエラーが返る() {
			String NOT_INPUT_MESSAGE = TestInputValue.notInputEmailError;
			String actual = Validation.emailCheck(EMPTY_EMAIL);
			assertThat(actual, is(NOT_INPUT_MESSAGE));
		}

		@Test
		public void メールアドレスが未入力でエラーが返る() {
			String NOT_INPUT_MESSAGE = TestInputValue.notInputEmailError;
			String actual = Validation.emailCheck(NULL_EMAIL);
			assertThat(actual, is(NOT_INPUT_MESSAGE));
		}

		@Test
		public void メールアドレスに不正な形式のアドレスを入力してエラーが返る() {
			String INVALID_MESSAGE = TestInputValue.invalidEmailError;
			String actual = Validation.emailCheck(INVALID_TYPE_EMAIL);
			assertThat(actual, is(INVALID_MESSAGE));
		}

		@Test
		public void メールアドレスに不正なアドレスを入力してエラーが返る() {
			String INVALID_MESSAGE = TestInputValue.invalidEmailError;
			String actual = Validation.emailCheck(INVALID_EMAIL);
			assertThat(actual, is(INVALID_MESSAGE));
		}

	}

	public static class パスワードが不正なとき {
		private User NOT_MATCH_PASSWORD = TestInputValue.notMatchPassword;
		private User EMPTY_PASSWORD = TestInputValue.emptyPassword;
		private User NULL_PASSWORD = TestInputValue.nullPassword;
		private User TOO_SHORT_PASSWORD = TestInputValue.tooShortPassword;
		private User TOO_LONG_PASSWORD = TestInputValue.toolongPassword;

		@Test
		public void 異なるパスワードを入力してエラーが返る() {
			String NOT_MATCH_MESSAGE = TestInputValue.notMatchPasswordError;
			String actual = Validation.emailCheck(NOT_MATCH_PASSWORD);
			assertThat(actual, is(NOT_MATCH_MESSAGE));
		}

		@Test
		public void 既定の文字以下のパスワードを入力してエラーが返る() {
			String INVALID_LENGTH_MESSAGE = TestInputValue.invalidLengthPasswordError;
			String actual = Validation.emailCheck(TOO_SHORT_PASSWORD);
			assertThat(actual, is(INVALID_LENGTH_MESSAGE));
		}

		@Test
		public void 既定の文字以上のパスワードを入力してエラーが返る() {
			String INVALID_LENGTH_MESSAGE = TestInputValue.invalidLengthPasswordError;
			String actual = Validation.emailCheck(TOO_LONG_PASSWORD);
			assertThat(actual, is(INVALID_LENGTH_MESSAGE));

		}

		@Test
		public void パスワードに空文字を入力してエラーが返る() {
			String NOT_INPUT_MESSAGE = TestInputValue.notInputPasswordError;
			String actual = Validation.emailCheck(EMPTY_PASSWORD);
			assertThat(actual, is(NOT_INPUT_MESSAGE));

		}

		@Test
		public void パスワードが未入力でエラーが返る() {
			String NOT_INPUT_MESSAGE = TestInputValue.notInputPasswordError;
			String actual = Validation.emailCheck(NULL_PASSWORD);
			assertThat(actual, is(NOT_INPUT_MESSAGE));

		}
	}
}