package guestbook2.action;

import guestbookDao.GuestBookDao;
import guestbookVo.GuestBookVo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.web.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pass");
		String msg = request.getParameter("content");
		
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setMsg(msg);
		
		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);
		
		response.sendRedirect("/guestbook2/gb");
	}

	
	

}
