package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivos")
public class Arquivos {
	
	@Id
	@Column
    int id;
    @Column
    String nome;
    @Column
    byte[] arquivo;
    
    Arquivos(){}
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public byte[] getArquivo() {
    	return arquivo;
    }
    
    public void setArquivo(byte[] arquivo) {
    	this.arquivo = arquivo;
    }
    
}
