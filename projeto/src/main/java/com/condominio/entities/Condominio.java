/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonio
 */
public class Condominio extends PessoaJuridica{
	
	private List<Servico> servicos = new ArrayList<>();
	private String sindico;
	
	public Condominio() {
		super();
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void addService(Servico servico) {
		servicos.add(servico);
	}
	
	public void removeService(Servico servico) {
		servicos.remove(servico);
	}

	public String getSindico() {
		return sindico;
	}

	public void setSindico(String sindico) {
		this.sindico = sindico;
	}
	

	@Override 
	public String toString() {
		return "***************************************\n"
				+">>>       DADOS DO CONDOMINIO       <<<\n"
				+ "\nSINDICO: " + this.sindico 
				+ super.toString()
				+ "\n>>> SERVIÃ‡OS <<< \n" 
				+ servicos 
				+ "\n***************************************";
	}
	
	public String toString(String string) {
		return "***************************************\n"
				+">>>       DADOS DO CONDOMINIO       <<<\n"
				+"NOME: " + super.getNome() + "\n"
				+"SINDICO: " + this.sindico + "\n"
				+"***************************************"; 

	}
	
}

