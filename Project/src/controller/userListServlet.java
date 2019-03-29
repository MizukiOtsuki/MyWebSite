package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class userListServlet
 */
@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userListServlet() {
        super();

    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	    HttpSession session = request.getSession();


	    if(session.getAttribute("userInfo") == null) {


	    	// loginサーブレットにリダイレクト
    		response.sendRedirect("loginServlet");
    		return;

	    }



		// ユーザ一覧情報を取得
				UserDao userDao = new UserDao();
				List<User> userList = userDao.findAll();

				// リクエストスコープにユーザ一覧情報をセット
				request.setAttribute("userList", userList);


		// ↓ フォワード UserList.jspを表示させる！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */



	//検索
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");


			String loginIdP = request.getParameter("loginId");
			String nameP = request.getParameter("name");


			UserDao userDao = new UserDao();
			List<User> userList = userDao.findSearch(loginIdP, nameP);

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList", userList);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);

	}

}