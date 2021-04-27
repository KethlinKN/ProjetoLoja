package br.com.senai.model;

public class LojaModel {
	// ATRIBUTOS
	private String nomeDoProduto;
	private double precoDoProduto;
	private int quantidadeDeProduto;
	private double saldoEmEstoque;
	private String carrinhoCompra;

	// CONSTRUTORES
	public LojaModel() {

	}

	public LojaModel(String nomeDoProduto, double precoDoProduto, int quantidadeDeProduto, double saldoEmEstoque, String carrinhoCompra) {
		super();
		this.nomeDoProduto = nomeDoProduto;
		this.precoDoProduto = precoDoProduto;
		this.quantidadeDeProduto = quantidadeDeProduto;
		this.saldoEmEstoque = saldoEmEstoque;
		this.carrinhoCompra = carrinhoCompra;
	}

	// METODOS
	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public double getPrecoDoProduto() {
		return precoDoProduto;
	}

	public void setPrecoDoProduto(double precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}

	public int getQuantidadeDeProduto() {
		return quantidadeDeProduto;
	}

	public void setQuantidadeDeProduto(int quantidadeDeProduto) {
		this.quantidadeDeProduto = quantidadeDeProduto;
	}

	public double getSaldoEmEstoque() {
		return saldoEmEstoque;
	}

	public void setSaldoEmEstoque(double saldoEmEstoque) {
		this.saldoEmEstoque = saldoEmEstoque;
	}
	public String getCarrinhoCompra() {
		return carrinhoCompra;
	}

	public void setCarrinhoCompra(String carrinhoCompra) {
		this.carrinhoCompra = carrinhoCompra;
	}
	


}
