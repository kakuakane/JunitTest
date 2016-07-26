package sample.validation;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static sample.validation.InputValue.EMPTY_EMAIL;
import static sample.validation.InputValue.EMPTY_NAME;
import static sample.validation.InputValue.EMPTY_PASSWORD;
import static sample.validation.InputValue.NOT_MATCH_EMAIL;
import static sample.validation.InputValue.NOT_MATCH_NAME;
import static sample.validation.InputValue.NOT_MATCH_PASSWORD;
import static sample.validation.InputValue.NULL_EMAIL;
import static sample.validation.InputValue.NULL_NAME;
import static sample.validation.InputValue.NULL_PASSWORD;
import static sample.validation.InputValue.RIGHT_USER;
import static sample.validation.Validation.ERR_MSG_EMPTY_EMAIL;
import static sample.validation.Validation.ERR_MSG_EMPTY_NAME;
import static sample.validation.Validation.ERR_MSG_EMPTY_PASSWORD;
import static sample.validation.Validation.ERR_MSG_INVALID_EMAIL;
import static sample.validation.Validation.ERR_MSG_INVALID_NAME;
import static sample.validation.Validation.ERR_MSG_INVALID_PASSWORD;

import java.util.List;

import org.junit.Test;

/***
 * Userの検証を行う.
 * 正常系のテスト：Userのプロパティが、下記の条件をすべて満たす。 
 * ・nameが漢字であること。
 * ・nameが空文字またはnullでないこと。
 * ・nameが"賀来"であること。
 * ・メールアドレスが空文字またはnullではないこと。
 * ・メールアドレスが"kaku@rakus.co.jp"であること。
 * ・パスワードが空文字またはnullではないこと。
 * ・パスワードが"kakuakane"であること。
 *
 * 異常系のテスト：Userのプロパティが下記の場合を検証し、適切なエラーメッセージを返す。 検証値については{@link InputValue}を参照
 * 
 * 例） 検証値                                                                                                       期待値
 *    new User("賀来","kaku@rakus.co.jp","aaaaaaaaa") パスワードの値が不正です
 * 
 * @author akane.kaku
 *
 */
public class ValidationTest {
	public static class 値が正しいとき {

		@Test
		public void 名前に正しい値を入力して正しい結果が返る() {
			Validation.nameCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
		}

		@Test
		public void メールアドレスに正しい値を入力して正しい結果が返る() {
			Validation.emailCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
		}

		@Test
		public void パスワードに正しい値を入力して正しい結果が返る() {
			Validation.passCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
		}
	}

	public static class 名前が不正なとき {
		//エラーメッセージが複数Listに格納されるため最後に追加されたエラーメッセージと期待値を比較する
		private List<String> errorMessageList = Validation.getErrorMessageList();

		@Test
		public void 名前に不正な値を入力してエラーが返る() {
			Validation.nameCheck(NOT_MATCH_NAME);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_INVALID_NAME));
		}

		@Test
		public void 名前が空文字でエラーが返る() {
			Validation.nameCheck(EMPTY_NAME);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_EMPTY_NAME));
		}

		@Test
		public void 名前が未入力でエラーが返る() {
			Validation.nameCheck(NULL_NAME);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_EMPTY_NAME));
		}
	}

	public static class メールアドレスが不正なとき {
		//エラーメッセージが複数Listに格納されるため最後に追加されたエラーメッセージと期待値を比較する
		private List<String> errorMessageList = Validation.getErrorMessageList();
		
		@Test
		public void メールアドレスに異なる値を入力してエラーが返る() {
			Validation.emailCheck(NOT_MATCH_EMAIL);
			System.out.println("notmatchemail.errorsize is\f" + errorMessageList.size());
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_INVALID_EMAIL));
		}

		@Test
		public void メールアドレスが空文字でエラーが返る() {
			Validation.emailCheck(EMPTY_EMAIL);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_EMPTY_EMAIL));
		}

		@Test
		public void メールアドレスが未入力でエラーが返る() {
			Validation.emailCheck(NULL_EMAIL);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_EMPTY_EMAIL));
		}

		// @Test
		// public void メールアドレスに不正な形式のアドレスを入力してエラーが返る() {
		// Validation.emailCheck(INVALID_TYPE_EMAIL);
		// assertTrue(Validation.hasError());
		// assertThat(Validation.getErrorMessageList(),
		// is(ERR_MSG_INVALID_TYPE_EMAIL));
		// }

		// @Test
		// public void メールアドレスに不正なアドレスを入力してエラーが返る() {
		// Validation.emailCheck(INVALID_EMAIL);
		// assertTrue(Validation.hasError());
		// assertThat(Validation.getErrorMessageList(),
		// is(ERR_MSG_INVALID_LENGTH));
		// }

	}

	public static class パスワードが不正なとき {
		//エラーメッセージが複数Listに格納されるため最後に追加されたエラーメッセージと期待値を比較する
		private List<String> errorMessageList = Validation.getErrorMessageList();

		@Test
		public void 異なるパスワードを入力してエラーが返る() {
			Validation.passCheck(NOT_MATCH_PASSWORD);
			System.out.println("notmatchpass is\f" + NOT_MATCH_PASSWORD.getPassword());
			System.out.println("notmatchpass.size is\f" + Validation.getErrorMessageList().size());
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_INVALID_PASSWORD));
		}

		@Test
		public void パスワードに空文字を入力してエラーが返る() {
			Validation.passCheck(EMPTY_PASSWORD);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_EMPTY_PASSWORD));
		}

		@Test
		public void パスワードが未入力でエラーが返る() {
			Validation.passCheck(NULL_PASSWORD);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(errorMessageList.size()-1), is(ERR_MSG_EMPTY_PASSWORD));
		}
		// @Test
		// public void 既定の文字以下のパスワードを入力してエラーが返る() {
		// Validation.emailCheck(TOO_SHORT_PASSWORD);
		// assertTrue(Validation.hasError());
		// assertThat(Validation.getErrorMessageList(),
		// is(ERR_MSG_TOO_SHORT_PASSWORD)); }
		// String NOT_INPUT_MESSAGE = InputValue.notInputPasswordError;
		// }

		// @Test
		// public void 既定の文字以上のパスワードを入力してエラーが返る() {
		// Validation.emailCheck(TOO_LONG_PASSWORD);
		// assertTrue(Validation.hasError());
		// assertThat(Validation.getErrorMessageList(),
		// is(ERR_MSG_TOO_LOND_PASSWORD));
		// }
	}
}