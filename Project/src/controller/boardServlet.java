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

import dao.BulletinBoardDao;
import model.BulletinBoard;
import model.User;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/boardServlet")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardServlet() {
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



	    //掲示板投稿の一覧を表示させるDaoのメソッドを実行
	    BulletinBoardDao bulletinBoardDao = new BulletinBoardDao();
	    List<BulletinBoard> BulletinBoardList = bulletinBoardDao.findAll();


	 // リクエストスコープにセット
		request.setAttribute("BulletinBoardList", BulletinBoardList);

		// ↓ フォワード bord.jspを表示させる！
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/board.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// HttpSessionインスタンスの取得
	    HttpSession session = request.getSession();

	    User u = (User) session.getAttribute("userInfo");


	    //入力項目を取得する
	    String title = request.getParameter("title");
		String postContent = request.getParameter("postContent");

		//入力項目にひとつでも未入力のものがある場合は登録をできない
				if(title.equals("") || postContent.equals("")) {

					// リクエストスコープにエラーメッセージをセット
						request.setAttribute("errMsg", "入力された内容は正しくありません");

					// 失敗した場合 bord.jspにフォワード
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/board.jsp");
						dispatcher.forward(request, response);
						return;

				}

				//掲示板に投稿するDAOのメソッドを実行する
				BulletinBoardDao bulletinBoardDao = new BulletinBoardDao();
				bulletinBoardDao.Write(title , postContent,u.getLoginId());


				// 投稿が成功したらサーブレットにリダイレクト
		 		response.sendRedirect("boardServlet");
				return;





	}

}
