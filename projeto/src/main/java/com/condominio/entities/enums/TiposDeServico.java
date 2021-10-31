/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.entities.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author antonio
 */
public enum TiposDeServico {
	MANUTENCAO("1"),
	PINTURA("2"),
	LIMPEZA("3"),
	SUBSTITUICAO("4");

	
	private String valor;
	
	private static final Map<String, TiposDeServico> ServicosPorValor = new HashMap<>();
	
	static {
		for (TiposDeServico servicos : TiposDeServico.values()) {
			ServicosPorValor.put(servicos.getValor(), servicos);
		}
	}
	
	TiposDeServico(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static TiposDeServico pegaServicos(String valor) {
		return ServicosPorValor.get(valor);
	}
	

}
 

