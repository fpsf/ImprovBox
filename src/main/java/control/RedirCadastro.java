package control;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class Cadastro
 */
public class RedirCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/cadastro.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("nome");
		String senha = request.getParameter("senha");
		JSONObject obj = new JSONObject();
		obj.put("nome", usuario);
		obj.put("senha", senha);
		try (FileWriter file = new FileWriter("/home/swagmence/eclipse-workspace/ImprovBox/usuario.txt")) {
			file.write(obj.toJSONString());
		}
		dispatcher(request, response);
		
	}
	
	protected void dispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		disp.forward(request, response);
	}

}
