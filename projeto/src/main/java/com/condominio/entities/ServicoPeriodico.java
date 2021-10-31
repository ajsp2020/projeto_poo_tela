/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author antonio
 */
public class ServicoPeriodico extends Servico {

	private Date nextDate;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ServicoPeriodico() {
		super();
	}

	public Date getNextDate() {
		return nextDate;
	}

	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	@Override
	public String toString() {
		return super.toString() 
				+ "\nPROXIMA DATA: " + this.sdf.format(nextDate);			
	}

}
