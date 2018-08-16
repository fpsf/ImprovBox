package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DAOTester {
	
	public static void main(String[] args) throws IOException {
		byte[] arq = {79, 32, 100, 111, 119, 110, 108, 111, 97, 100, 32, 102, 117, 110, 99, 105, 111, 110, 111, 117};
		DAO dao = new DAO();
		dao.objeto(1, "arquivodeteste", arq);
		dao.guardar();
		dao = new DAO();
		dao.remover(1);
		byte[] arq2 = Files.readAllBytes(new File("usuario.txt").toPath());
		dao = new DAO();
		dao.objeto(1, "usuario.txt", arq2);
		dao.guardar();
		//dao.objeto(1);
		System.out.println(dao.localizar(1).getNome());
		//dao.objeto(2, "arquivodeteste", arq);
		//dao.guardar();
	}
	
}
