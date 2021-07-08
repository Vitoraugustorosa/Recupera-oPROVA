package br.com.motorista;

import java.util.Calendar;

import br.com.veiculo.Veiculo;

public class Motorista {
	private String nome;
	private int idade;
	private String categoriaHabilitacao;
	private Veiculo veiculo2 = new Veiculo();
	
	
	
	private int anoDeNacimento;
	
	public int getAnoDeNacimento() {
		return anoDeNacimento;
	}
	public void setAnoDeNacimento(int anoDeNacimento) {
		this.anoDeNacimento = anoDeNacimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		Calendar calendar = Calendar.getInstance();
		this.idade = idade = calendar.get(Calendar.YEAR) - getAnoDeNacimento();
	}
	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	public Veiculo getVeiculo2() {
		return veiculo2;
	}
	public void setVeiculo2(Veiculo veiculo2) {
		this.veiculo2 = veiculo2;
	}
}
