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
 * Servlet implementation class userDeleteServlet
 */
@WebServlet("/userDeleteServlet")
public class userDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDeleteServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	    HttpSession session = request.getSession();


	    if(session.getAttribute("userInfo") == null) {


	    	// loginサーブレットにリダイレクト
    		response.sendRedirect("loginServlet");
    		return;

	    }


    	String id = request.getParameter("id");

    	// Daoのメソッドを実行する
		UserDao userDao = new UserDao();
		User userDetail = userDao.UserDetail(id);

		// リクエストスコープにセット
		request.setAttribute("userDetail", userDetail);


		// ↓ フォワード userDelete.jspを表示させる！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
		dispatcher.forward(request, response);

		return;

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		//文字化け防止のため
		request.setCharacterEncoding("UTF-8");


		// 入力項目を取得する
		String id = request.getParameter("id");


		//Daoのメソッドを実行
		UserDao userDao = new UserDao();
		 userDao.Delete(id);


		 //ユーザー一覧画面にリダイレクト
		response.sendRedirect("userListServlet");

	}

}
