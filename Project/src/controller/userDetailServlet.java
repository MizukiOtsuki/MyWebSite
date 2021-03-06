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
 * Servlet implementation class userDetailServlet
 */
@WebServlet("/userDetailServlet")
public class userDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDetailServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	    HttpSession session = request.getSession();


	    if(session.getAttribute("userInfo") == null) {


	    	// loginサーブレットにリダイレクト
    		response.sendRedirect("loginServlet");
    		return;

	    }


    	// リクエストパラメータの文字コードを指定 文字化け防止！
        request.setCharacterEncoding("UTF-8");

    	String id = request.getParameter("id");


    	// ユーザ一覧情報を取得
		UserDao userDao = new UserDao();
		User userDetail = userDao.UserDetail(id);

		// リクエストスコープにユーザー情報をセット
		request.setAttribute("userDetail", userDetail);



    	// ↓ フォワード userDetail.jspを表示させる！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDetail.jsp");
		dispatcher.forward(request, response);
	}


}