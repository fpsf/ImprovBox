package control;

import model.Arquivos;
import model.DAO;

public class OPSBD {
	
	DAO dao;
	public Arquivos arqtst;
	
	public OPSBD(){
		dao = new DAO();
	}
	
	public void deletar(int id) {
		dao.remover(id);
	}
	
	public void guardar(int id, String nome, byte[] arquivo) {
		if(dao.existe(id) == false) {
			dao.objeto(id, nome, arquivo);
			dao.guardar();
		}
		else {
			dao.objeto(id, nome, arquivo);
			dao.atualizar();
		}
		// dao.manager.getTransaction().commit();
	}
	
	public void recuperar(int id) {
		arqtst = dao.localizar(id);
	}
	
}
