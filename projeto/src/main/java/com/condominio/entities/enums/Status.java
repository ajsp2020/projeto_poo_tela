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
public enum Status {
	
	NAO_INICIADO("1"),
	INICIADO("2"),
	CONCLUIDO("3"),
	OUTROS("4");
	
private String valor;
	
	private static final Map<String, Status> StatusPorValor = new HashMap<>();
	
	static {
		for (Status servicos : Status.values()) {
			StatusPorValor.put(servicos.getValor(), servicos);
		}
	}
	
	Status(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static Status pegaServicos(String valor) {
		return StatusPorValor.get(valor);
	}


}