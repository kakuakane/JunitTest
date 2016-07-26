package sample.common;

import static org.junit.Assert.*;
import static sample.validation.Validation.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

import static sample.common.User.*;
import static sample.validation.InputValue.*;

import org.junit.Test;

import sample.validation.InputValue;
import sample.validation.Validation;

public class TestServletTest {
	public static class 入力値がすべて正しいとき {
		List<String> errorMessageList = Validation.getErrorMessageList();

		@Test
		public void hasErrorメソッドでfalseが返る() {
			Validation.nameCheck(RIGHT_USER);
			Validation.emailCheck(RIGHT_USER);
			Validation.passCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
			assertThat(errorMessageList.size(), is(0));
		}
	}

	public static class エラーメッセージが2つ存在するとき {
		List<String> errorMessageList = Validation.getErrorMessageList();
		private static final User INVALID_NAME_AND_EMAIL = new User(InputValue.NOT_MATCH_NAME.getName(),
				InputValue.NOT_MATCH_EMAIL.getEmail(), InputValue.RIGHT_USER.getPassword());
		private static final User INVALID_EMAIL_AND_PASSWORD = new User(InputValue.RIGHT_USER.getName(),
				InputValue.NOT_MATCH_EMAIL.getEmail(), InputValue.NOT_MATCH_PASSWORD.getPassword());
		private static final User INVALID_NAME_AND_PASSWORD = new User(InputValue.NOT_MATCH_NAME.getName(),
				InputValue.RIGHT_USER.getEmail(), InputValue.NOT_MATCH_PASSWORD.getPassword());

		@Test
		public void 名前とメールアドレスにエラーがある() {
			Validation.nameCheck(INVALID_NAME_AND_EMAIL);
			Validation.emailCheck(INVALID_NAME_AND_EMAIL);
			Validation.passCheck(INVALID_NAME_AND_EMAIL);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.size(), is(2));
		}

		@Test
		public void メールアドレスとパスワードにエラーがある() {
			Validation.nameCheck(INVALID_EMAIL_AND_PASSWORD);
			Validation.emailCheck(INVALID_EMAIL_AND_PASSWORD);
			Validation.passCheck(INVALID_EMAIL_AND_PASSWORD);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.size(), is(2));
		}
		@Test
		public void 名前パスワードにエラーがある(){
			Validation.nameCheck(INVALID_NAME_AND_PASSWORD);
			Validation.emailCheck(INVALID_NAME_AND_PASSWORD);
			Validation.passCheck(INVALID_NAME_AND_PASSWORD);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.size(),is(2));
		}
	}


}
