package control;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirDown
 */
public class RedirDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OPSBD ops = new OPSBD();
			ops.recuperar(1);
			byte[] btarq = ops.arqtst.getArquivo();
			response.setContentType("application/txt");
			response.setHeader("Content-Disposition", "attachment;filename=temp" + ops.arqtst.getNome() + ".txt");
			response.setContentLength(btarq.length);
			OutputStream os = response.getOutputStream();

			try {
			   os.write(btarq , 0, btarq.length);
			} catch (Exception excp) {
			   //handle error
			} finally {
			    os.close();
			}
		}
		catch(Exception e){
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Falha no download, provavelmente não há nenhum arquivo no banco, poste um.');</script>");
		}
		
	}

}
