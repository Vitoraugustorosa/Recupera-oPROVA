package br.com.controles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.motorista.Motorista;
import br.com.veiculo.Veiculo;

public class ProgamaPrincipal {
	public static void main(String[] args) {
		List<Motorista> motoristas = new ArrayList<Motorista>();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		Scanner in = new Scanner(System.in);
		boolean sair = true;

		VeiculoController veiculoController = new VeiculoController();
		MotoristaController motoristaController  = new MotoristaController();
		do {
			menuPrincipal();
			int opcao = in.nextInt();

			switch (opcao) {
				case 1:
					motoristaController.menuMotorista(motoristas, veiculos);
					break;

				case 2:
					veiculoController.menuVeiculo(veiculos, motoristas);
					break;

				case 0:
					System.out.println("\nSistema Finalizado!");
					sair = false;
					break;

				default:
					System.out.println("Opção Inválida!");
					break;
			}

		} while (sair);
		in.close();
	}
public static void menuPrincipal() {
		System.out.println("\n=== MENU PRINCIPAL ===");
		System.out.println("1 - Registro Motorista");
		System.out.println("2 - Registro Veiculo");
		System.out.println("0 - Sair");
		System.out.println("======================");

		System.out.print("> ");
	
	}
}