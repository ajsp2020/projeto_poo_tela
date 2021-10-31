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
public class Empresa extends PessoaJuridica{
	
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Empresa () {
		super();
		
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void addNumber(Telefone telefone) {
		this.telefones.add(telefone);
	}
	
	public void removeNumber(Telefone telefone) {
		this.telefones.remove(telefone);
	}

	@Override
	public String toString() {
		return "\nNOME DA EMPRESA: " + this.getNome() 
				+ "\nENDEREÃ‡O: " + this.getEndereco()
				+ "\nCNPJ: " + this.getCnpj()
				+ "\nTELEFONE: \n" + telefones ;
	}
	
}
