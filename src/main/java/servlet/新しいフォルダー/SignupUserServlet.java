package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/SignupUserServlet")
public class SignupUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//フォワード先
		String forwardPath = null;
		
		//サーブレットクラスの動作を決定する"action"の値をリクエストパラメータから取得
		String action = request.getParameter("action");
		
		//「登録の開始」をリクエストされたときの処理
		if(action == null) {
			//フォワード先を設定
			forwardPath = "/registerForm.jsp";
		}
		
		//登録確認画面から「登録実行」をリクエストされたときの処理
		else if(action.equals("done")) {

			
			//登録後のフォワード先を設定
			forwardPath = "/registerDone.jsp";
		}
		
		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String input_userID = request.getParameter("userID");
		int userID = Integer.parseInt(input_userID);
		
		/*--------------------------------------------------------------------------------------*/
		//"User"型のフィールド"userID"と"email"は用途が重複している可能性ありか？
		//User型の扱われ方が把握できていないので一旦両方残しています
		//→"userID"はDBのプライマリキー：内部処理で用いる変数なので、UserDAO.createUser()内で重複しない値を付与する
		//→フォームから入力するのは"name","email","pass"のみ
		/*--------------------------------------------------------------------------------------*/

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		//登録するユーザーの情報を設定
		User registerUser = new User(name,userID,email,pass,false);
		registerUser.setHashedPass(pass);

		//管理者フラグに関する処理
		/*	<未定義>	*/
		//

		//ユーザー情報をDBへ記録
		UserDAO uDAO = new UserDAO();
		uDAO.createUser(registerUser);


		//セッションスコープに登録ユーザを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
