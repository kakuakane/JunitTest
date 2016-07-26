package sample.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import sample.common.User;
import sample.validation.Validation;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApiServlet() {
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
		String nameCheck = Validation.nameCheck(user);
		String emailCheck = Validation.emailCheck(user);
		String passCheck = Validation.passCheck(user);
		System.out.println("validationのチェック" + nameCheck);
		List<String> errorList = new ArrayList<>();
		boolean check = true;
		if (!(nameCheck == null)) {
			System.out.println("nameCheckのエラー");
			errorList.add(nameCheck);
			check = false;
		}
		if (!(emailCheck == null)) {
			System.out.println("emailCheckのエラー");
			errorList.add(emailCheck);
			check = false;
		}
		if (!(passCheck == null)) {
			System.out.println("passCheckのエラー");
			errorList.add(passCheck);
			check = false;
		}

		if (check) {
			request.setAttribute("result", "認証成功");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/result.jsp");
			// rd.forward(request, response);
		} else {
			request.setAttribute("result", "認証失敗");
			// RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
			// rd.forward(request, response);
		}

		System.out.println("API");
		String responseJson = JSON.encode(new Message("failure"));
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(responseJson);

	}

	private class Message {
		private String message;

		public Message(String msg) {
			message = msg;
		}

		public String getMessage() {
			return message;
		}
	}
}
