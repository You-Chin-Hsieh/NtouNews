package Servlet;

import java.awt.Window.Type;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NewsReader.News;

/**
 * Servlet implementation class NewsSender
 */
@WebServlet("/NewsSender")
public class NewsSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsSender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		ServletContext servletContext = request.getServletContext();
		//System.out.println(request.getAttribute("list"));
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<News>> list = (ArrayList<ArrayList<News>>)servletContext.getAttribute("NewsAllList");
		String[] TypeList = {"台灣最新新聞","科技最新新聞","運動最新新聞","娛樂最新新聞"};
		String[] IconList = {"fa fa-flag","fa fa-mobile","fa fa-male","fa fa-smile-o"};
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("type", 0);
		httpSession.setAttribute("list", list);
		httpSession.setAttribute("TypeList", TypeList);
		httpSession.setAttribute("IconList", IconList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//System.out.println("doget:"+list);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
