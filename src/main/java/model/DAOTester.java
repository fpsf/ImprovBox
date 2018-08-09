package model;

public class DAOTester {
	
	public static void main(String[] args) {
		byte[] arq = {79, 32, 100, 111, 119, 110, 108, 111, 97, 100, 32, 102, 117, 110, 99, 105, 111, 110, 111, 117};
		DAO dao = new DAO();
		dao.objeto(1, "arquivodeteste", arq);
		dao.guardar();
		//dao.remover(1);
		//dao.objeto(1);
		System.out.println(dao.localizar(1).getNome());
		//dao.objeto(2, "arquivodeteste", arq);
		//dao.guardar();
	}
	
}
