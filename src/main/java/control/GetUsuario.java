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
		// "/home/swagmence/eclipse-workspace/ImprovBox/usuario.txt"
		try (FileReader file = new FileReader("usuario.txt")) {
			char[] cbuf = new char[(int)new File("usuario.txt").length()];
			file.read(cbuf);
			String text = String.valueOf(cbuf);

			PrintWriter out = response.getWriter();
			out.println(text);
		} /*catch (Exception e) {
			System.out.println("não consegui ler o arquivo");
			System.out.println(e.getStackTrace());
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
