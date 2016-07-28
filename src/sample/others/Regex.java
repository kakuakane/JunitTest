package sample.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 正規表現が正常に動作するか確認するクラス.
 * @author rks_user
 *
 */
public class Regex {
	public static void main(String[] args) {
		String a = "aA0-";
		String b = "^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$";
		String c = "(?=.*)(?=.*[a-zA-Z]+.*).*[!@#$%]+.*";
		String d = "(?!^[^0-9]*$)(?!^[^a-z]*$)(?!^[^A-Z]*$)(?!^[^-_]*$)^([a-zA-Z0-9-_-]+)$";
		Pattern p = Pattern.compile(d);
		Matcher m = p.matcher(a);
		System.out.println(m.find());

		// メールアドレスの形式
		p = Pattern.compile("[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+");
		m = p.matcher("rakus@co.jp");
		System.out.println(m.find());

	}
}
