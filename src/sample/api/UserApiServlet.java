package sample.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import sample.common.ResultMessage;
import sample.common.User;
import sample.common.ValidationResponse;
import sample.validation.Validation;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/UserApiServlet")
public class UserApiServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserApiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=" + "UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("formの受け取り" + name);

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		// Validation
		Validation.listReset();	//レスポンスメッセージの初期化
		Validation.nameCheck(user);
		Validation.emailCheck(user);
		Validation.passCheck(user);
		Validation.getErrorMessageList();
		if (!(Validation.hasError())) {
			System.out.println("成功");
			System.out.println("vv");
			String responseJson = JSON.encode(new ResultMessage("認証成功"));
			response.setContentType("application/json;charaset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(responseJson);
//			request.setAttribute("result", "認証成功");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/result.jsp");
			// rd.forward(request, response);
		}
		if (Validation.hasError()) {
			System.out.println("失敗");
			System.out.println(Validation.hasError());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
//			String responseJson = JSON.encode(new ResultMessage("認証失敗"));
//			response.setContentType("application/json;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print(responseJson);
			
			//エラーメッセージの表示
			String resJson = JSON.encode(Validation.getErrorMessageList());
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter pw = response.getWriter();
//			for (String error : Validation.getErrorMessageList()) {
//				String errorList = error +"\r\n";
//				System.out.println(errorList);
//				pw.print(errorList);
//			}
			pw.print(resJson);
			// RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
			// rd.forward(request, response);
		}

//		System.out.println("API");
//		String responseJson = JSON.encode(new Message("failure"));
//		response.setContentType("application/json;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print(responseJson);

	}

}


