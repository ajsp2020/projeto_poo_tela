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
public enum TiposDeTelefone {
	
	FIXO("1"),
	CELULAR("2");
	
	private String valor;
	
	private static final Map<String, TiposDeTelefone> TelefonePorValor = new HashMap<>();
	
	static {
		for (TiposDeTelefone servicos : TiposDeTelefone.values()) {
			TelefonePorValor.put(servicos.getValor(), servicos);
		}
	}
	
	TiposDeTelefone(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static TiposDeTelefone pegaTelefones(String valor) {
		return TelefonePorValor.get(valor);
	}
	
}
