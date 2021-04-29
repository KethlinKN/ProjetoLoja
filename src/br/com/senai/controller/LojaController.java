package br.com.senai.controller;

import java.util.List;
import java.util.Scanner;

import br.com.senai.model.CarrinhoModel;
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
				"1- Cadastrar itens.\n2- Listar estoque.\n3- Editar item.\n4- Remover item.\n5- Adicionar ao carrinho.\n6- Listar itens do carrinho.\n9- Sair do sistema.\n");

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
		System.out.println("-------------- PRODUTOS CADASTRADOS -------------");
		System.out.printf("| %2s | %10s | %8s | %4s | %9s |\n", "ID", "Produto", "Preço ", "Qtd", "R$ Total");

		// for (LojaModel produtoModel : produtos) {
		// System.out.printf("| %10s | %8s | %4s | %9s |\n",
		// produtoModel.getNomeDoProduto(), produtoModel.getPrecoDoProduto(),
		// produtoModel.getQuantidadeDeProduto(), produtoModel.getSaldoEmEstoque());
		// }

		// produtos.forEach(produto -> {
		// System.out.printf("| %2s | %10s | R$%6.2f | %4s | %9s
		// |\n",produto.getNomeDoProduto(), produto.getPrecoDoProduto(),
		// produto.getQuantidadeDeProduto(), produto.getSaldoEmEstoque());
		//
		// });

		for (int i = 0; i < produtos.size(); i++) {
			System.out.printf("| %2s | %10s | R$%6.2f | %4s | %9s |\n", i + 1, produtos.get(i).getNomeDoProduto(),
					produtos.get(i).getPrecoDoProduto(), produtos.get(i).getQuantidadeDeProduto(),
					produtos.get(i).getSaldoEmEstoque());
		}
		return produtos;
	}

	public LojaModel editarProduto(List<LojaModel> produtos) {
		LojaModel lojamodel = new LojaModel();
		int idDoProduto, indexDoCampo;

		if (produtos.size() <= 0) {
			System.out.println("Não possui produtos para serem editados!\n");
			return null;
		}
		ListarEstoque(produtos);

		System.out.println("--- EDITAR DADOS DE PRODUTOS ---");
		System.out.printf("Informe o ID do produto: ");
		idDoProduto = scanner.nextInt() - 1;

		if (idDoProduto > produtos.size()) {
			System.out.println("Esse produto não exite!\n");
			return null;
		}

		System.out.println("-------- CAMPOS --------");
		System.out.println("1- Nome do produto.");
		System.out.println("2- Preço unitário.");
		System.out.println("3- Quantidade.");
		System.out.print("Informe o campo que deseja editar: ");
		indexDoCampo = scanner.nextInt();

		switch (indexDoCampo) {
		case 1:
			lojamodel.setPrecoDoProduto(produtos.get(idDoProduto).getPrecoDoProduto());
			lojamodel.setQuantidadeDeProduto(produtos.get(idDoProduto).getQuantidadeDeProduto());
			lojamodel.setSaldoEmEstoque(produtos.get(idDoProduto).getSaldoEmEstoque());

			System.out.print("Informe o novo nome para o produto: ");
			lojamodel.setNomeDoProduto(scanner.next());

			produtos.set(idDoProduto, lojamodel);
			break;
		case 2:
			lojamodel.setNomeDoProduto(produtos.get(idDoProduto).getNomeDoProduto());
			lojamodel.setQuantidadeDeProduto(produtos.get(idDoProduto).getQuantidadeDeProduto());

			System.out.print("Informe o novo preço para o produto: ");
			lojamodel.setPrecoDoProduto(scanner.nextDouble());
			lojamodel.setSaldoEmEstoque(
					produtos.get(idDoProduto).getQuantidadeDeProduto() * lojamodel.getPrecoDoProduto());

			produtos.set(idDoProduto, lojamodel);
			break;
		case 3:
			lojamodel.setNomeDoProduto(produtos.get(idDoProduto).getNomeDoProduto());
			lojamodel.setPrecoDoProduto(produtos.get(idDoProduto).getPrecoDoProduto());
			lojamodel.setSaldoEmEstoque(produtos.get(idDoProduto).getSaldoEmEstoque());

			System.out.print("Informe a nova quantidade para o produto: ");
			lojamodel.setQuantidadeDeProduto(scanner.nextInt());
			lojamodel.setSaldoEmEstoque(
					produtos.get(idDoProduto).getPrecoDoProduto() * lojamodel.getQuantidadeDeProduto());

			produtos.set(idDoProduto, lojamodel);
			break;

		default:
			System.out.println("Opção Inválida!!");
			break;
		}

		return null;
	}

	public void carrinhoCompra(List<LojaModel> produtos, List<CarrinhoModel> carrinho) {
		CarrinhoModel carrinhoC = new CarrinhoModel();
		ListarEstoque(produtos);
		System.out.println("-------- CARRINHO DE COMPRAS --------");
		System.out.print("Informe o ID do produto a ser adicionado carrinho: ");
		int idDoProduto = scanner.nextInt();
		if (idDoProduto > produtos.size()) {
			System.out.println("Não possui produtos para com esse ID!");
			return;
		}
		idDoProduto--;
		System.out.println("Informe a quantidade que deseja adicionar ao carrinho: ");
		int qtdProduto = scanner.nextInt();
		if(qtdProduto > produtos.get(idDoProduto).getQuantidadeDeProduto()) {
			System.out.println("Não temos essa quantidade em estoque!");
			return;
		}
		produtos.get(idDoProduto).setQuantidadeDeProduto(produtos.get(idDoProduto).getQuantidadeDeProduto() - qtdProduto);
		produtos.get(idDoProduto).setSaldoEmEstoque(produtos.get(idDoProduto).getQuantidadeDeProduto() * produtos.get(idDoProduto).getPrecoDoProduto());
		carrinhoC.setNomeDoProdutoComprado(produtos.get(idDoProduto).getNomeDoProduto());
		carrinhoC.setPrecoDoProdutoComprado(produtos.get(idDoProduto).getPrecoDoProduto());
		carrinhoC.setQuantidadeDeProdutoComprado(qtdProduto);
		carrinhoC.setSaldoEmEstoqueComprado(qtdProduto * carrinhoC.getPrecoDoProdutoComprado());
		carrinho.add(carrinhoC);
	}
	
	public List<CarrinhoModel> listarCarrinho(List<CarrinhoModel> carrinho) {
		System.out.println("-------- PRODUTOS NO CARRINHO -------");
		System.out.printf("| %2s | %10s | %8s | %4s | %9s |\n", "ID", "Produto", "Preço ", "Qtd", "R$ Total");
		System.out.println("---------- CARRINHO DE COMPRAS ----------");
		for (int i = 0; i < carrinho.size(); i++) {
			System.out.printf("| %2s | %10s | R$%6.2f | %4s | %9s |\n", i + 1, carrinho.get(i).getNomeDoProdutoComprado(),
					carrinho.get(i).getPrecoDoProdutoComprado(), carrinho.get(i).getQuantidadeDeProdutoComprado(),
					carrinho.get(i).getSaldoEmEstoqueComprado());
		}
		return carrinho;
		
	}
	
	public void removerProduto(List<LojaModel> produtos) {
		System.out.println("---------------- REMOVER PRODUTO ----------------");
		if (produtos.size() <= 0) {
			System.out.println("Não possui produtos para serem removidos!");
			return;
		}
		ListarEstoque(produtos);
		System.out.print("Informe o ID do produto a ser removido: ");
		int idDoProduto = scanner.nextInt();

		if (idDoProduto > produtos.size()) {
			System.out.println("Este produto não foi cadastrado!");
			return;
		}

		produtos.remove(idDoProduto - 1);

	}


}
