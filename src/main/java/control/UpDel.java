package control;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


public class UpDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OPSBD ops = new OPSBD();
			ops.deletar(1);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
		}
		catch(Exception e){
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Falha ao deletar, provavelmente não há nenhum arquivo no banco, poste um.');</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Part part = request.getPart("arquivo");
			String name = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    InputStream content = part.getInputStream();
		    byte[] arq = IOUtils.toByteArray(content);
		    OPSBD ops = new OPSBD();
		    ops.guardar(1, name, arq);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
		}
		catch(Exception e) {
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
		}
		/*
		try {
			OPSBD ops = new OPSBD();
			byte[] arq = {79, 32, 100, 111, 119, 110, 108, 111, 97, 100, 32, 102, 117, 110, 99, 105, 111, 110, 111, 117};
			ops.guardar(1, "arquivodeteste", arq);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
		}
		catch(Exception e){
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Falha ao enviar, provavelmente já existe um arquivo no banco, apague-o.');</script>");
		}
		*/
		
	}

}
