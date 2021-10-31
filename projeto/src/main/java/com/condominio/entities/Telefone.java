/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.entities;

import com.condominio.entities.enums.TiposDeTelefone;
import com.condominio.exceptions.ProgramException;

/**
 *
 * @author antonio
 */
public class Telefone {

	private TiposDeTelefone tipo;
	private String ddd;
	private String numero;

	public Telefone() {

	}


	public TiposDeTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeTelefone tipo) {
		this.tipo = tipo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		validaDdd(ddd);
		this.ddd = ddd;

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		validaNumero(numero);
		this.numero = numero;
	}

	

	private void validaDdd(String ddd) {
		if (ddd.length() != 2) {
			throw new ProgramException("O ddd precisa possuir dois valores");
		}
	}
	
	private void validaNumero(String numero) {
		if (numero.length() != 9) {
			throw new ProgramException("Adicione um nÃºmero vÃ¡lido");
		}
	}
	
	@Override
	public String toString() {
		return "\n" + tipo + ":" + " (" + ddd + ") " + numero;
	}

}
