package br.com.controles;

import java.util.List;
import java.util.Scanner;

import br.com.motorista.Motorista;
import br.com.senai.curso.Curso;
import br.com.veiculo.Veiculo;

public class VeiculoController {

	private Scanner in;

	public VeiculoController() {
		in = new Scanner(System.in);
	}

	public void MenuVeiculo(List<Veiculo> veiculos, List<Motorista> motoristas) {
		System.out.println("\n=== MENU VEICULOS ===");
		System.out.println("1 - Cadastrar Veiculoo");
		System.out.println("2 - Listar Veiculos");
		System.out.println("3 - Editar Veiculo");
		System.out.println("4 - Excluir Veiculo");
		System.out.println("=========================");
		System.out.print("> ");
		int opcao = in.nextInt();
		switch (opcao) {
		case 1:
			veiculos.add(cadastrarVeiculo());
			break;

		case 2:
			listarVeiculos(veiculos);
			break;

		case 3:
			editarVeiculos(veiculos, motoristas);
			break;

		case 4:
			excluirVeiculo(veiculos, motoristas);
			break;

		default:
			System.out.println("Opção Inválida!");
			break;
			
		}
	}

	private void editarVeiculos(List<Veiculo> veiculos, List<Motorista> motoristas) {
		// TODO Auto-generated method stub
		
	}

	public List<Veiculo> listarVeiculos(List<Veiculo> veiculos) {
		
		if (veiculos.isEmpty()) {
			System.out.println("\nNão possui veiculos cadastrados.");
			return null;
		}
		System.out.println("Veiculos Cadastrados");
		
		System.out.printf("|10%s|4%s|4%s|4%s\n","Modelo", "Ano", "TipoDeCombustivel", "Placa");
		
		for (int i = 0; i < veiculos.size(); i++) {
			System.out.printf("|10%s|4%d|4%s|4%d", i + 1, veiculos.get(i).getMarca(),veiculos.get(i).getModelo(),veiculos.get(i).getPlaca(),veiculos.get(i).getTipoCombustivel());
		}
		return veiculos;

		
	}

	private Veiculo cadastrarVeiculo() {
		System.out.println("\n=== CADASTRAR VEICULO ===");

		Veiculo veiculo = new Veiculo();

		in.nextLine();

		System.out.print("Informe o modelo do veiculo: ");
		veiculo.setModelo(in.nextLine());
		
		System.out.println("Infome o ano do veiculo");
		veiculo.setAno(in.nextInt());
		
		System.out.println("Informe o tipo do combustivel");
		veiculo.setTipoCombustivel(in.nextLine());
		
		System.out.println("Infrome a placa");
		veiculo.setPlaca(in.nextInt());

		System.out.println("\nVeiculo cadastrado!");

		return veiculo;
	
		
	}
	
	
}
