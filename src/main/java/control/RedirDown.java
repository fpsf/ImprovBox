package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

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
			
			File targetfile = new File("/home/swagmence/eclipse-workspace/ImprovBox/" + ops.arqtst.getNome());
			
			FileUtils.writeByteArrayToFile(targetfile, btarq);
			
			response.setContentType(Files.probeContentType(targetfile.toPath()));
			response.setHeader("Content-Disposition","attachment; filename=" + ops.arqtst.getNome());
			response.setContentLength(btarq.length);
			OutputStream os = response.getOutputStream();
			FileInputStream in = new FileInputStream(targetfile);
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0){
			    os.write(buffer, 0, length);
			}
			in.close();
			os.flush();
		    os.close();
		    RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
		    
		}
		catch(Exception e){
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Falha no download, provavelmente não há nenhum arquivo no banco, poste um.');</script>");
		}
		
	}

}
