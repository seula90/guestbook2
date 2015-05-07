package guestbook2.servlet;

import guestbook2.action.DeleteAction;
import guestbook2.action.FormAction;
import guestbook2.action.IndexAction;
import guestbook2.action.InsertAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.web.Action;

/**
 * Servlet implementation class Guestbook2Servlet
 */
@WebServlet("/gb")
public class Guestbook2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Guestbook2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			
			String a = request.getParameter("a");

			Action action = null;
			if ("form".equals(a)) {
				action = new FormAction();

			} else if ("insert".equals(a)) {
				action = new InsertAction();

			} else if ("delete".equals(a)) {
				action = new DeleteAction();
			}

			if (action == null) {
				action = new IndexAction();

			}
			action.execute(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
