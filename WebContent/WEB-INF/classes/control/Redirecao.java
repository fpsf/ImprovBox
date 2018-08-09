package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirecao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upload = request.getParameter("up_redir");
		String download = request.getParameter("down_redir");
		String deletar = request.getParameter("del_redir");
		String redir = null;
		while (redir == null) {
			if (upload != null){
				redir = upload;
			}
			if (download != null){
				redir = download;
			}
			if (deletar != null){
				redir = deletar;
			}
			if (upload == null && download == null &&
					deletar == null) {
				PrintWriter erro = response.getWriter();
				erro.print("<script>alert('Algo deu errado...');"
						+ "</script>");
				break;
			}
			
		}
		if(redir != null) {
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/" + redir + ".jsp");
			disp.forward(request, response);
		}
		else {
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
	}

}
