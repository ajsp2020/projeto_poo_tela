/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.entities;

/**
 *
 * @author antonio
 */
public abstract class PessoaJuridica {
	
	private String nome;
	private Endereco endereco;
	private String cnpj;
	
	public PessoaJuridica() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "NOME: " + nome 
				+ "\nCNPJ: " + cnpj
				+ "\nENDEREÃ‡O: " + endereco ;
	}

	
}

