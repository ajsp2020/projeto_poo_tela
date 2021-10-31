/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.application;

import com.condominio.entities.Condominio;
import com.condominio.entities.Servico;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author antonio
 */

public class Program {
    public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Condominio cliente = null;

		boolean sair = false;

		while (!sair) {

			UI.clearScreen();

			if (UI.clienteExiste(cliente)) {
				System.out.println(cliente.toString("Menu"));
			}
			UI.imprimeMenu();

			System.out.print(">>> ");
			int opt = sc.nextInt();

			UI.clearScreen();
			switch (opt) {

			case 0: {

				sair = true;

				break;
			}

			case 1: {

				if (!UI.clienteExiste(cliente)) { // Checando se o cliente existe
					cliente = UI.addDadosCondominio(new Condominio(), sc);
				} else {

					System.out.println("Deseja trocar o cliente? (S/N)");
					char ch = sc.next().toLowerCase().charAt(0);

					if (ch == 's') {

						cliente = UI.addDadosCondominio(cliente, sc);

					} else {

						break;
					}
				}

				break;
			}

			case 2: {

				if (!UI.clienteExiste(cliente)) { // Checando se o cliente existe
					sc.nextLine();
					sc.nextLine(); // Tem dois pq o p1rograma nÃ£o esta parando com um sÃ³

				} else {

					cliente.addService(UI.criaServico(sc));
				}

				break;
			}

			case 3: {
				if (UI.clienteExiste(cliente)) {

					System.out.println(cliente);
				}

				UI.Pause();
				break;
			}

			case 4: {
				if (UI.clienteExiste(cliente)) {
					UI.imprimeMenuDois();
					System.out.print(">>>");
					opt = sc.nextInt();

					switch (opt) {

					case 1: {
						Date agora = new Date();

						for (Servico servico : cliente.getServicos()) {
							if (servico.getData().after(agora)) {
								System.out.println(servico);
							}
						}

						UI.Pause();
						break;
					}
					case 2: {
						System.out.println("A partir de qual data?");
						Date data = UI.criaData(sc);

						for (Servico servico : cliente.getServicos()) {
							if (servico.getData().after(data)) {
								System.out.println(servico);
							}
						}

						UI.Pause();
						break;
					}
					case 3: {
						System.out.println(cliente.getServicos());

						UI.Pause();
						break;
					}
					default: {
						break;
					}

					}

				}
				break;
			}
			case 5: {
				if (UI.clienteExiste(cliente)) {
					for (Servico servico : cliente.getServicos()) {
						System.out.println(servico.getEmpresa());
					}
				}

				UI.Pause();
				break;
			}

			default:

				break;
			}

		}

		sc.close();

	}
}
