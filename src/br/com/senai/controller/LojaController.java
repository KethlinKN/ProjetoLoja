package br.com.senai.controller;

import java.util.List;
import java.util.Scanner;

import br.com.senai.model.LojaModel;

public class LojaController {
	private Scanner scanner;

	public LojaController() {
		scanner = new Scanner(System.in);
	}

	public int opcao() {
		System.out.print("> ");
		return scanner.nextInt();
	}

	public void menu() {
		System.out.println("- - - M E N U - - - ");
		System.out.println(
				"1- Cadastrar itens.\n2- Listar estoque.\n3- Editar item.\n4- Remover item.\n5- Realizar venda.\n9- Sair do sistema.\n");

	}

	public LojaModel cadastrarProduto() {
		LojaModel lojaModel = new LojaModel();

		System.out.println("- - -  CADASTRAR ITENS - - - ");
		System.out.print("Produto: ");
		scanner.nextLine();
		lojaModel.setNomeDoProduto(scanner.nextLine());
		System.out.print("Preço: ");
		lojaModel.setPrecoDoProduto(scanner.nextDouble());
		System.out.print("Quantidade: ");
		lojaModel.setQuantidadeDeProduto(scanner.nextInt());
		System.out.println("");

		lojaModel.setSaldoEmEstoque(lojaModel.getQuantidadeDeProduto() * lojaModel.getPrecoDoProduto());

		System.out.println("Produto cadastrado com sucesso!");
		return lojaModel;

	}

	public void ListarEstoque(List<LojaModel> produtos) {
		System.out.println("---- PRODUTOS CADASTRADOS ----");
		System.out.printf("| %10s | | %8s | %4s | 9% |\n", "Nome do Produto: ", "Valor do Produto: R$ ", "Quantidade do Produto: ", "Saldo em Estoque: R$");
		for (LojaModel produtoModel : produtos) {
			System.out.println(produtoModel);
		}
	}

}
