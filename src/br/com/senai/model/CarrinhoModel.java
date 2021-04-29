package br.com.senai.model;

public class CarrinhoModel {
	// ATRIBUTOS
	private String nomeDoProdutoComprado;
	private double precoDoProdutoComprado;
	private int quantidadeDeProdutoComprado;
	private double saldoEmEstoqueComprado;
	private String carrinhoCompraComprado;

	// CONSTRUTORES
	public CarrinhoModel() {

	}

	public CarrinhoModel(String nomeDoProdutoComprado, double precoDoProdutoComprado, int quantidadeDeProdutoComprado, double saldoEmEstoqueComprado, String carrinhoCompraComprado) {
		super();
		this.nomeDoProdutoComprado = nomeDoProdutoComprado;
		this.precoDoProdutoComprado = precoDoProdutoComprado;
		this.quantidadeDeProdutoComprado = quantidadeDeProdutoComprado;
		this.saldoEmEstoqueComprado = saldoEmEstoqueComprado;
		this.carrinhoCompraComprado = carrinhoCompraComprado;
	}
	
	public String getNomeDoProdutoComprado() {
		return nomeDoProdutoComprado;
	}

	public void setNomeDoProdutoComprado(String nomeDoProdutoComprado) {
		this.nomeDoProdutoComprado = nomeDoProdutoComprado;
	}

	public double getPrecoDoProdutoComprado() {
		return precoDoProdutoComprado;
	}

	public void setPrecoDoProdutoComprado(double precoDoProdutoComprado) {
		this.precoDoProdutoComprado = precoDoProdutoComprado;
	}

	public int getQuantidadeDeProdutoComprado() {
		return quantidadeDeProdutoComprado;
	}

	public void setQuantidadeDeProdutoComprado(int quantidadeDeProdutoComprado) {
		this.quantidadeDeProdutoComprado = quantidadeDeProdutoComprado;
	}

	public double getSaldoEmEstoqueComprado() {
		return saldoEmEstoqueComprado;
	}

	public void setSaldoEmEstoqueComprado(double saldoEmEstoqueComprado) {
		this.saldoEmEstoqueComprado = saldoEmEstoqueComprado;
	}

	public String getCarrinhoCompraComprado() {
		return carrinhoCompraComprado;
	}

	public void setCarrinhoCompraComprado(String carrinhoCompraComprado) {
		this.carrinhoCompraComprado = carrinhoCompraComprado;
	}

}
