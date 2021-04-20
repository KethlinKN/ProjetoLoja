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

	public List<LojaModel> ListarEstoque(List<LojaModel> produtos) {
		System.out.println("---------- PRODUTOS CADASTRADOS ----------");
		System.out.printf("| %10s | %8s | %4s | %9s |\n", "Produto", "Preço ", "Qtd", "R$ Total");
		
		// for (LojaModel produtoModel : produtos) {
		// System.out.printf("| %10s | %8s | %4s | %9s |\n",
		// produtoModel.getNomeDoProduto(), produtoModel.getPrecoDoProduto(),
		// produtoModel.getQuantidadeDeProduto(), produtoModel.getSaldoEmEstoque());
		// }

		produtos.forEach(produto -> {
			System.out.printf("| %10s | %8s | %4s | %9s |\n", produto.getNomeDoProduto(), produto.getPrecoDoProduto(),
					produto.getQuantidadeDeProduto(), produto.getSaldoEmEstoque());
		});
		return produtos;
	}

	public LojaModel editarProduto(List<LojaModel> produtos) {
		LojaModel lojamodel = new LojaModel();
		int idDoProduto, indexDoCampo;
		
		System.out.println("--- EDITAR DADOS DE PRODUTOS ---");
		System.out.printf("Informe o ID do produto: ");
		idDoProduto = scanner.nextInt();
		
		System.out.println("-------- CAMPOS --------");
		System.out.println("1- Nome do produto.");
		System.out.println("2- Preço unitário.");
		System.out.println("3- Quantidade.");
		System.out.print("Informe o campo que deseja editar: ");
		indexDoCampo = scanner.nextInt();
		
		switch(indexDoCampo) {
		case 1:
			lojamodel.setPrecoDoProduto(produtos.get(idDoProduto).getPrecoDoProduto());
			lojamodel.setQuantidadeDeProduto(produtos.get(idDoProduto).getQuantidadeDeProduto());
			lojamodel.setSaldoEmEstoque(produtos.get(idDoProduto).getSaldoEmEstoque());
			
			System.out.print("Informe o novo nome para o produto: ");
			lojamodel.setNomeDoProduto(scanner.next());
			
			produtos.set(idDoProduto, lojamodel);
			break;
		case 2:
			lojamodel.setPrecoDoProduto(produtos.get(idDoProduto).getPrecoDoProduto());
			lojamodel.setQuantidadeDeProduto(produtos.get(idDoProduto).getQuantidadeDeProduto());
			lojamodel.setSaldoEmEstoque(produtos.get(idDoProduto).getSaldoEmEstoque());
			
			System.out.print("Informe o novo preço para o produto: ");
			
			
			produtos.set(idDoProduto, lojamodel);
			break;
	
		
		
		default:
			break;
		}
		
		
		return null;
	}

}
