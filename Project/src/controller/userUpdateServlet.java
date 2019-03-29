package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class userUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//
	    HttpSession session = request.getSession();


	    if(session.getAttribute("userInfo") == null) {


	    	// loginサーブレットにリダイレクト
    		response.sendRedirect("loginServlet");
    		return;

	    }


		String id = request.getParameter("id");

		UserDao userDao = new UserDao();
		User userDetail = userDao.UserDetail(id);

		// リクエストスコープにセット
		request.setAttribute("userDetail", userDetail);


		// ↓ フォワード update.jspを表示させる！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);

		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//文字化け防止のため
		request.setCharacterEncoding("UTF-8");


		// 入力項目を取得する
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");




		//パスワードとパスワード(確認)の入力内容が異なる場合は登録をできない
				if(!password.equals(password2)) {


					// リクエストスコープにエラーメッセージをセット
					request.setAttribute("errMsg", "入力された内容は正しくありません");

					// 更新に失敗した場合 doGetメソッドを呼び出して入力画面に戻す
					doGet(request,response);
					return;


				}

			//入力漏れなどがなければDaoのメソッドを実行
		UserDao userDao = new UserDao();

		if(password.equals("") && password2.equals("")) {

			userDao.update(name,id);

		}else {

			userDao.Update(name,password, id);
		}




		 //更新が成功すればユーザー一覧画面にリダイレクト
		response.sendRedirect("userListServlet");

	}

}
