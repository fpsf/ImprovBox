package control;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUsuario
 */
public class GetUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (FileReader file = new FileReader("/home/swagmence/eclipse-workspace/ImprovBox/usuario.txt")) {
			char[] cbuf = new char[(int)new File("/home/swagmence/eclipse-workspace/ImprovBox/usuario.txt").length()];
			file.read(cbuf);
			String text = String.valueOf(cbuf);
			PrintWriter out = response.getWriter();
			out.println(text);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
