/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.condominio.application;

import com.condominio.entities.Condominio;
import com.condominio.entities.Empresa;
import com.condominio.entities.Endereco;
import com.condominio.entities.PessoaJuridica;
import com.condominio.entities.Servico;
import com.condominio.entities.ServicoPeriodico;
import com.condominio.entities.Telefone;
import com.condominio.entities.enums.Status;
import com.condominio.entities.enums.TiposDeServico;
import com.condominio.entities.enums.TiposDeTelefone;
import com.condominio.exceptions.ProgramException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class UI {

	

   	protected static void Pause() {
		int inChar;
		System.out.println("Enter a Character:");
		try {
			inChar = System.in.read();
			System.out.print("You entered ");
			System.out.println(inChar);
		} catch (IOException e) {
			System.out.println("Error reading from user");
		}
	}

	protected static void imprimeMenu() {
		
		System.out.println("***************************************");
		System.out.println("*           MENU DE OPÃ‡Ã•ES:           *");
		System.out.println("* 0 - Sair                            *");
		System.out.println("* 1 - Adicionar CondomÃ­nnio           *");
		System.out.println("* 2 - Adicionar ServiÃ§o               *");
		System.out.println("* 3 - Mostrar Dados                   *");
		System.out.println("* 4 - Mostrar ServiÃ§os                *");
		System.out.println("* 5 - Mostrar Empresas                *");
		System.out.println("***************************************");
		

	}

	protected static void imprimeMenuDois() {
		System.out.println("1 - ServiÃ§os posteriores a data de hoje:");
		System.out.println("2 - ServiÃ§os por data especÃ­fica:");
		System.out.println("3 - Todos os serviÃ§os");
	}

	protected static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	protected static boolean clienteExiste(Condominio cliente) {
		if (cliente != null) {
			return true;
		}
		return false;
	}

	private static boolean aceita(Scanner sc) {
		char ch = sc.next().toLowerCase().charAt(0);

		if (ch == 's') {
			return true;
		}
		return false;
	}

	
	protected static Condominio addDadosCondominio(Condominio cliente, Scanner sc) {

		PessoaJuridica dados = criaDados(cliente, sc);
		cliente = (Condominio) dados;

		System.out.print("Sindico: ");
		cliente.setSindico(sc.nextLine());

		return cliente;
	};

	protected static Servico criaServico(Scanner sc) {

		Servico servico = new Servico();

		System.out.print("Ã‰ um serviÃ§o periÃ³dico? (s/n): ");

		if (aceita(sc)) {
			servico = new ServicoPeriodico();
		}

		addDadosServico(servico, sc);

		return servico;
	}

	private static void addDadosServico(Servico servico, Scanner sc) {

		servico.setTipo(TiposDeServico.pegaServicos(addTipos(sc)));

		servico.setEmpresa(criaEmpresa(sc));

		System.out.println("Deseja adicionar uma data especÃ­fica? (s/n)");
		System.out.print(">>> ");

		if (aceita(sc)) {
			System.out.print("Data (DD/MM/YYYY): ");
			servico.setData(criaData(sc));

			if (servico instanceof ServicoPeriodico) {
				System.out.print("Proxima Data (DD/MM/YYYY): ");
				((ServicoPeriodico) servico).setNextDate(criaData(sc));
			}
		}
		else {
			servico.setData(new Date());
		}

		addPreco(servico, sc);

		servico.setStatus(Status.pegaServicos(addStatus(sc)));

	};

	private static PessoaJuridica criaDados(PessoaJuridica dados, Scanner sc) {

		sc.nextLine();
		System.out.print("Nome: ");
		dados.setNome(sc.nextLine());

		dados.setEndereco(criaEndereco(sc));

		// sc.nextLine();
		System.out.print("CNPJ: ");
		dados.setCnpj(sc.nextLine());

		return dados;
	}

	private static Endereco criaEndereco(Scanner sc) {

		Endereco endereco = new Endereco();

		System.out.println("Deseja adicionar o endereÃ§o?");
		System.out.print(">>> ");

		if (aceita(sc)) {
			addDadosEndereco(endereco, sc);
		} else {
			sc.nextLine();
		}

		return endereco;

	};

	private static void addDadosEndereco(Endereco endereco, Scanner sc) {

		try { // Melhorar !
			sc.nextLine();

			System.out.print("Rua: ");
			endereco.setRua(sc.nextLine());

			System.out.print("Numero: ");
			endereco.setNumero(sc.nextLine());

			System.out.print("CEP: ");
			endereco.setCep(sc.nextLine());

			System.out.print("Cidade: ");
			endereco.setCidade(sc.nextLine());

			System.out.print("Estado: ");
			endereco.setEstado(sc.nextLine());

			System.out.print("Pais: ");
			endereco.setPais(sc.nextLine());

		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			addDadosEndereco(endereco, sc);
		}

	}

	private static Telefone criaNoTelefone(Scanner sc) {

		Telefone telefone = new Telefone();

		sc.nextLine();
		addDadosTelefone(telefone, sc);

		return telefone;

	};

	private static void addDadosTelefone(Telefone telefone, Scanner sc) {

		try {
			System.out.println("Tipo: \n" 
					+ "1 - FIXO \n" 
					+ "2 - CELULAR ");

			System.out.print(">>> ");
			telefone.setTipo(TiposDeTelefone.pegaTelefones(sc.nextLine()));

			System.out.print("DDD: ");
			telefone.setDdd(sc.nextLine());

			System.out.print("Numero: ");
			telefone.setNumero(sc.nextLine());
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			addDadosTelefone(telefone, sc);
		}

	}

	private static String addTipos(Scanner sc) {

		String[] tipos = { "1 - MANUTENÃ‡ÃƒO",
				"2 - PINTURA", 
				"3 - LIMPEZA", 
				"4 - SUBSTITUIÃ‡ÃƒO" };

		for (String lista : tipos) {
			System.out.println(lista);
		}

		System.out.print("Tipo: ");
		String valor = sc.next();

		return valor;
	}

	private static Empresa criaEmpresa(Scanner sc) {

		Empresa empresa = new Empresa();

		addDadosEmpresa(empresa, sc);

		return empresa;
	};

	private static void addDadosEmpresa(Empresa empresa, Scanner sc) {

		PessoaJuridica dados = criaDados(empresa, sc);
		empresa = (Empresa) dados;

		System.out.println("Deseja adicionar um numero? (s/n)");
		boolean resposta = aceita(sc);
		while (resposta) {

			Telefone telefone = criaNoTelefone(sc);
			empresa.addNumber(telefone);
			System.out.println("Deseja adicionar outro numero? (s/n)");
			resposta = aceita(sc);
		}

	}

	protected static Date criaData(Scanner sc) {

		Date data = new Date();

		modificaData(data, sc);

		return data;
	}

	private static void modificaData(Date data, Scanner sc) {
		
		try { 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(sc.next());
		} catch (ParseException e) { 
			System.out.print("A data precisa ser (dd/MM/yyyy): ");
			modificaData(data, sc);
		}

	};

	private static void addPreco(Servico servico, Scanner sc) {

		try {
			System.out.print("Valor do serviÃ§o R$: ");
			servico.setPreco(sc.nextDouble());
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			addPreco(servico, sc);
		}
		sc.nextLine();
	};

	private static String addStatus(Scanner sc) {

		System.out.println("Status: \n" 
				+ "1 - NAO_INICIADO \n"
				+ "2 - INICIADO \n"
				+ "3 - COMPLETADO \n" 
				+ "4 - OUTROS: ");

		System.out.print(">>> ");
		String valor = sc.nextLine();

		return valor;
	};
	


    
}
