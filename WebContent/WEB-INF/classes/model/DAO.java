package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAO {
	
	Arquivos arquivo;
	public EntityManager manager;
	int id;
	EntityManagerFactory factory;
	
	// "e04fd020ea3a6910a2d808002b30309d".getBytes()
	public void objeto(int id, String nome, byte[] arquivo) {
		this.arquivo = new Arquivos();
		this.arquivo.id = id;
		this.arquivo.nome = nome;
		this.arquivo.arquivo = arquivo;
	}
	
	public DAO() {
		this.factory = Persistence.createEntityManagerFactory("arquivos");
		manager = factory.createEntityManager();
		manager.getTransaction().begin(); 
	}
	
	public void objeto(int id) {
		Arquivos aq = new Arquivos();
		aq.setId(id);
		// this.arquivo = null;
		this.arquivo = aq;
	}
	
	
	
	public void guardar() {
		// manager.getTransaction().begin();        
	    manager.persist(arquivo);
	    manager.flush();
	    manager.clear();
	    manager.getTransaction().commit();
	}
	
	@SuppressWarnings("deprecation")
	public void atualizar() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getSessionFactory().getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.update(arquivo);
        tr.commit();
        session.close();
        manager.getTransaction().commit();
	}
	
	public void remover(int id) {
		arquivo = manager.find(Arquivos.class, id);
	    // manager.getTransaction().begin();
	    manager.remove(arquivo);
	    manager.getTransaction().commit();
	}

	public boolean existe(int id2) {
		arquivo = manager.find(Arquivos.class, id2);
		if(arquivo != null) {
			return true;
		}
		return false;
	}

	public Arquivos localizar(int id2) {
		// manager = factory.createEntityManager();
		return manager.find(Arquivos.class, id2);
		
	}
	
	public Arquivos localiza() {
		return manager.find(Arquivos.class, this.arquivo);
	}
	
}
