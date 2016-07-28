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
import static sample.validation.Validation.*;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sample.common.User;

/***
 * 入力値の検証を行う.
 * 正常系のテスト：Userのプロパティが、下記の条件をすべて満たす。 
 * ・名前、メールアドレス、パスワードが空文字またはnullではないこと。
 * ・名前が「賀来」であること。
 * ・メールアドレスが"kaku@rakus.co.jp"であること。
 * ・パスワードが"kakuakane"であること。
 *
 * 異常系のテスト：Userのプロパティが下記の場合を検証し、適切なエラーメッセージを返す。 検証値については{@link InputValue}を参照
 * 
 * @author akane.kaku
 *
 */
public class ValidationTest {

	//エラーメッセージが複数Listに格納されるため最後に追加されたエラーメッセージと期待値を比較する
			private List<String> errorMessageList = Validation.getErrorMessageList();
	/**
	 * リストの中身を空にする
	 */
	@Before
	public void listSetUp(){
		Validation.listReset();
	}
		/**
		 * 名前に正しい値を入力して正しい結果が返る 
		 * テスト項目				検証値											期待値
		 *・名前が「賀来」である　　　　　　　	new User("賀来","kaku@rakus.co.jp","kakuakane")	エラーなし
		 */
		@Test
		public void 名前にを入力して正しい結果が返る() {
			Validation.nameCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
		}
		
		/**
		 * メールアドレスに正しい値を入力して正しい結果が返る
		 * テスト項目							検証値											期待値
		 *・メールアドレスがkaku@rakus.co.jpである		new User("賀来","kaku@rakus.co.jp","kakuakane")	エラーなし
		 */
		@Test
		public void メールアドレスに正しい値を入力して正しい結果が返る() {
			Validation.emailCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
		}

		/**
		 * パスワードに正しい値を入力して正しい結果が返る
		 * テスト項目							検証値											期待値
		 * ・パスワードがkakuakaneである				new User("賀来","kaku@rakus.co.jp","kakuakane")	エラーなし
		 */
		@Test
		public void パスワードに正しい値を入力して正しい結果が返る() {
			Validation.passCheck(RIGHT_USER);
			assertFalse(Validation.hasError());
		}

		/**
		 * 正誤チェック
		 * テスト項目							検証値											期待値
		 * ・nameが正しいユーザーと一致していない			new User("aaa","kaku@rakus.co.jp","kakuakane")	名前が不正です
		 */
		@Test
		public void 名前に不正な値を入力してエラーが返る() {

//			URLValue url = URLBuilder("aaa","kaku@rakus.co.jp","kakuakane");
			//http://localhost:8080/JunitTest/UserApiServlet?name=%E8%B3%80%E6%9D%A5&email=aaa&password=fff
//			Htppclient cli = new HttpClient();
//			String responseMessageJson = cli.GET(url);
//			String message = JSONIC.decode(responseMessageJson); //TODO 面倒かも。。。
			assertTrue(Validation.hasError());
//			assertThat(message, is(ERR_MSG_INVALID_NAME));
			Validation.nameCheck(NOT_MATCH_NAME);
			assertThat(errorMessageList.get(0), is(ERR_MSG_INVALID_NAME));
		}

		/**
		 * 空文字チェック
		 * テスト項目				検証値											期待値
		 * ・nameが空文字			new User("","kaku@rakus.co.jp","kakuakane")。	名前を入力してください
		 */
		@Test
		public void 名前が空文字でエラーが返る() {
			Validation.nameCheck(EMPTY_NAME);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_EMPTY_NAME));
		}

		/** 
		 * nullチェック
		 * テスト項目				検証値											期待値
		 * ・nameが空文字			new User(null,"kaku@rakus.co.jp","kakuakane")	名前を入力してください
		 */
		@Test
		public void 名前が未入力でエラーが返る() {
			Validation.nameCheck(NULL_NAME);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_EMPTY_NAME));
		}
		
		/**
		 * 文字列の長さチェック
		 * テスト項目				検証値													期待値
		 * ・入力値が10文字以内である	new User("asdfghjklsdf","kaku@rakus.co.jp","kakuakane")	名前は10文字以内で入力してください
		 */
		@Test
		public void 名前に10文字より長い文字を入力したときエラーが返る(){
			
		}
		
		/**
		 * 複数エラーチェック
		 * テスト項目					検証値									期待値
		 * ・名前とメールアドレスが不正である		new User("aaa","aaa@aaa","kakuakane")	名前が不正です	メールアドレスが不正です
		 * 
		 */
		@Test
		public void 名前とメールアドレスのエラーが出る(){
			
		}
			
		/**
		 * 正誤チェック
		 * テスト項目							検証値											期待値
		 *・メールアドレスが正しいユーザーと一致していない		new User("賀来","aaa@rakus.co.jp","kakuakane")	メールアドレスが不正です
		 */
		@Test
		public void メールアドレスに異なる値を入力してエラーが返る() {
			Validation.emailCheck(NOT_MATCH_EMAIL);
			System.out.println("notmatchemail.errorsize is\f" + errorMessageList.size());
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_INVALID_EMAIL));
		}

		/**
		 * 空文字チェック
		 * テスト項目					検証値								期待値
		 * ・メールアドレスが空文字である		new User("賀来","","kakuakane")		メールアドレスを入力してください
		 */
		@Test
		public void メールアドレスが空文字でエラーが返る() {
			Validation.emailCheck(EMPTY_EMAIL);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_EMPTY_EMAIL));
		}

		/**
		 * nullチェック
		 * テスト項目					検証値								期待値
		 * ・メールアドレスがnullである		new User("賀来",null,"kakuakane")	メールアドレスを入力してください
		 */
		@Test
		public void メールアドレスが未入力でエラーが返る() {
			Validation.emailCheck(NULL_EMAIL);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_EMPTY_EMAIL));
		}

		/**
		 * 長さチェック
		 * テスト項目
		 * ・メールアドレスが50文字以内である		new User("賀来","asdfghjkaqwe1rty_uioxcvbnz234xcvbnm@678rakus.co.jp","kakuakane")
		 * 								メールアドレスは50文字以内で入力してください
		 */

//		@Test
//		public void メールアドレスに50文字より長いアドレスを入力してエラーが返る() {
//			Validation.emailCheck(INVALID_EMAIL);
//			assertTrue(Validation.hasError());
//			assertThat(Validation.getErrorMessageList(),
//					is(ERR_MSG_INVALID_LENGTH));
//		}
		
		/**
		 * 長さチェック(min)
		 * テスト項目
		 * ・メールアドレスが文字以内である		new User("賀来","asdfghjkaqwe1rty_uioxcvbnz234xcvbnm@678rakus.co.jp","kakuakane")
		 * 								
		 *							メールアドレスは50文字以内で入力してください
		 */
//		@Test
//		public void メールアドレスに50文字より長いアドレスを入力してエラーが返る() {
//			Validation.emailCheck(INVALID_EMAIL);
//			assertTrue(Validation.hasError());
//			assertThat(Validation.getErrorMessageList(),
//					is(ERR_MSG_INVALID_LENGTH));
//		}
		 
		/**
		 * 正規表現チェック
		 * テスト項目							検証値									期待値
		 * ・メールアドレスに@と.（ピリオド）が含まれている		new User("賀来","aaabb","kakuakane")		メールアドレスの形式が不正です
		 */
		@Test
		 public void メールアドレスに不正な形式のアドレスを入力してエラーが返る() {
//		 Validation.emailCheck(INVALID_TYPE_EMAIL);
//		 assertTrue(Validation.hasError());
//		 assertThat(Validation.getErrorMessageList(),
//		 is(ERR_MSG_INVALID_TYPE_EMAIL));
			Validation.regexEmail(new User("aaa","aaabb",".-..._.--."));
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0),
					is(ERR_MSG_REJEX_EMAIL));
		 }
		
		/**
		 * 複数エラーチェック
		 * テスト項目					検証値										期待値
		 * ・メールアドレスとパスワードが不正である		new User("賀来","aaa@aaa","adk13_dkaaa")	メールアドレスが不正です  	パスワードが不正です
		 * 
		 */
		@Test
		public void メールアドレスとパスワードのエラーが出る(){
			
		}

		/**
		 * 正誤チェック
		 * テスト項目						検証値											期待値
		 * ・パスワードが正しいユーザーと一致していない	new User("賀来","kaku@rakus.co.jp","aaaaaaaaa")	パスワードが不正です
		 */
		@Test
		public void 異なるパスワードを入力してエラーが返る() {
			Validation.passCheck(NOT_MATCH_PASSWORD);
			System.out.println("notmatchpass is\f" + NOT_MATCH_PASSWORD.getPassword());
			System.out.println("notmatchpass.size is\f" + Validation.getErrorMessageList().size());
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_INVALID_PASSWORD));
		}

		/**
		 * 空文字チェック
		 * テスト項目				検証値									期待値
		 * ・パスワードが空文字である		new User("賀来","kaku@rakus.co.jp","")	パスワードを入力してください
		 * 
		 */
		@Test
		public void パスワードに空文字を入力してエラーが返る() {
			Validation.passCheck(EMPTY_PASSWORD);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_EMPTY_PASSWORD));
		}

		/**
		 * nullチェック
		 * テスト項目				検証値										期待値
		 * ・パスワードがnullである		new User("賀来","kaku@rakus.co.jp",null)		パスワードを入力してください
		 * 
		 */
		@Test
		public void パスワードが未入力でエラーが返る() {
			Validation.passCheck(NULL_PASSWORD);
			assertTrue(Validation.hasError());
			assertThat(errorMessageList.get(0), is(ERR_MSG_EMPTY_PASSWORD));
		}
		
		/**
		 *長さチェック
		 * テスト項目					検証値
		 * ・パスワードが8文字以上である		new User("賀来","kaku@rakus.co.jp","asdfghj")
		 * 							期待値
		 * 							パスワードは8文字以上16文字以内で入力してください
		 */
//		@Test
//		 public void 既定の文字以下のパスワードを入力してエラーが返る() {
//		 Validation.emailCheck(TOO_SHORT_PASSWORD);
//		 assertTrue(Validation.hasError());
//		 assertThat(Validation.getErrorMessageList(),
//		 is(ERR_MSG_TOO_SHORT_PASSWORD)); }
//		 String NOT_INPUT_MESSAGE = InputValue.notInputPasswordError;
//		 }

		/**
		 * 長さチェック
		 * テスト項目					検証値
		 * ・パスワードが16文字以内である		new User("賀来","kaku@rakus.co.jp","asdfghjklasdfghjkl")
		 * 							期待値
		 * 							パスワードは8文字以上16文字以内で入力してください
		 */

//		@Test
//		 public void 既定の文字以上のパスワードを入力してエラーが返る() {
//		 Validation.emailCheck(TOO_LONG_PASSWORD);
//		 assertTrue(Validation.hasError());
//		 assertThat(Validation.getErrorMessageList(),
//		 is(ERR_MSG_TOO_LOND_PASSWORD));
//		 }
		
		/**
		 * 正規表現チェック
		 * テスト項目							検証値
		 * ・パスワードが半角英数字記号すべて含んでいる		new User("賀来","kaku@rakus.co.jp","aacvvhhhh")
		 * 									期待値
		 * 									パスワードは半角英数字記号すべて含めてください
		 */
		@Test
		public void パスワードにアルファベットのみを入力してエラーが返る(){
			Validation.regexPass(new User("aaa","kaku@rakus.co.jp","aacvvhhhh"));
			 assertTrue(Validation.hasError());
			 assertThat(errorMessageList.get(0),
			 is(ERR_MSG_REJEX_PASSWORD));
		}
		
		/**
		 * 正規表現チェック
		 * テスト項目							検証値
		 * ・パスワードが半角英数字記号すべて含んでいる		new User("賀来","kaku@rakus.co.jp","174947273")
		 * 									期待値
		 * 									パスワードは半角英数字記号すべて含めてください
		 * 
		 */
		@Test
		public void パスワードに数字のみを入力してエラーが返る(){
			Validation.regexPass(new User("aaa","kaku@rakus.co.jp","174947273"));
			 assertTrue(Validation.hasError());
			 assertThat(errorMessageList.get(0),
			 is(ERR_MSG_REJEX_PASSWORD));
		}
		
		/**
		 * 正規表現チェック
		 * テスト項目							検証値
		 * ・パスワードが半角英数字記号すべて含んでいる		new User("賀来","kaku@rakus.co.jp",".-..._.--.")
		 * 									期待値
		 * 									パスワードは半角英数字記号すべて含めてください
		 */
		@Test
		public void パスワードに記号のみを入力してエラーが返る(){
			Validation.regexPass(new User("aaa","kaku@rakus.co.jp",".-..._.--."));
			 assertTrue(Validation.hasError());
			 assertThat(errorMessageList.get(0),
			 is(ERR_MSG_REJEX_PASSWORD));
		}
		/**
		 * 複数エラーチェック
		 * テスト項目					検証値											期待値
		 * ・名前とパスワードが不正である		new User("aaa","kaku@rakus.co.jp","adbhfdacgh")	名前が不正です	パスワードは半角英数字記号すべて含めてください
		 * 
		 */
		@Test
		public void パスワードと名前のエラーが出る(){
			
		}
}
