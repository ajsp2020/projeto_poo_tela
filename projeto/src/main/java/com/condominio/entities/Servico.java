/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.entities;

import com.condominio.entities.enums.Status;
import com.condominio.entities.enums.TiposDeServico;
import com.condominio.exceptions.ProgramException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author antonio
 */
public class Servico {
	
	private TiposDeServico tipo;
	private Empresa empresa;
	private Date initialData;
	private Double preco;
	private Status status;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public Servico() {
		
	}

	public TiposDeServico getTipo() {	
		return tipo;
	}

	
	public void setTipo(TiposDeServico tipo) {
		this.tipo = tipo;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Date getData() {
		return initialData;
	}


	public void setData(Date data) {
		
		this.initialData = data;
	}


	public Double getPreco() {
		return preco;
	}
	

	public void setPreco(Double preco) {
		validaPreco(preco);
		this.preco = preco;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	private void validaPreco(Double preco) {
		if(preco < 0) {
			throw new ProgramException("O preÃ§o precisa ser um valor maior que zero.");
		}
	}
	
	


	@Override
	public String toString() {
		return "\nTIPO: " + this.tipo 
				+ "\nNOME DA EMPRESA: " + empresa.getNome() 
				+ "\nDATA: " + this.sdf.format(initialData) 
				+ "\nPREÃ‡O: R$ " + String.format("%.2f", this.preco)
				+ "\nSTATUS: " + this.status;
	}

	
}

