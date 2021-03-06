package guestbook2.action;

import guestbookDao.GuestBookDao;
import guestbookVo.GuestBookVo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		String pwd = request.getParameter("password");
			
		GuestBookVo vo = new GuestBookVo();
		
		vo.setNo(no);
		vo.setPwd(pwd);
			
		
		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);
		
		response.sendRedirect("/guestbook2/gb");

	}

}
