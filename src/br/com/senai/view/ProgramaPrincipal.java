package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;
import br.com.senai.controller.LojaController;
import br.com.senai.model.CarrinhoModel;
import br.com.senai.model.LojaModel;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		List<LojaModel> produtos = new ArrayList <LojaModel>();
		List<CarrinhoModel> carrinho = new ArrayList<CarrinhoModel>();
		
		//OBJETO CONTROLLER DO SISTEMA
		LojaController lojaController =  new LojaController();
		
		//CONTROLE DO LOOP DE SAIDA
		boolean sair = false;
		
		do {
			lojaController.menu();
			int opcao = lojaController.opcao();
			switch(opcao) {
			case 1:
				produtos.add(lojaController.cadastrarProduto());
				break;
			case 2:
				lojaController.ListarEstoque(produtos);
				break;
			case 3:
				lojaController.editarProduto(produtos);
				break;
			case 4:
				lojaController.removerProduto(produtos);
				break;
			case 5:
				lojaController.carrinhoCompra(produtos, carrinho);
				break;
			case 6:
				lojaController.listarCarrinho(carrinho);
				break;
			case 9:
				sair = true;
				break;
				
				default:
					System.out.println("Op??o inv?lida!");
			}
			
			
		} while(!sair);
		System.out.println("Sistema encerrado!!!");
		
		

	}

}
