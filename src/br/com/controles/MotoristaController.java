package br.com.controles;

import java.util.List;
import java.util.Scanner;

import br.com.motorista.Motorista;
import br.com.veiculo.Veiculo;

public class MotoristaController {
	
	private Scanner in;
	
	public MotoristaController() {
		in = new Scanner(System.in);
		}
	
	public void MenuMotorista(List<Veiculo> veiculos, List<Motorista> motoristas) {
		System.out.println("\n==== Menu Motorista ====");
		System.out.println("1 - Cadastrar Motorista");
		System.out.println("2 - Listar Motoristas");
		System.out.println("3 - Editar Motorista");
		System.out.println("4 - Excluir Motorista");
		System.out.println("====================");

		System.out.print("> ");
		int opcao = in.nextInt();
		
		switch (opcao) {
		case 1:
			veiculos.add(cadastrarMotorista(veiculos, motoristas));
			break;

		case 2:
			listarMotoristas(motoristas);
			break;

		case 3:
			editarMotorista(motoristas, veiculos);
			break;

		case 4:
			excluirMotorista(motoristas);
			break;

		default:
			System.out.println("Opção Inválida!");
			break;
	}
}

	public  Motorista excluirMotorista(List<Motorista> motoristas) {
		
		if (motoristas.isEmpty()) {
			System.out.println("\nNão possui motoristas cadastrados.");
			return null;
		}
		listarMotoristas(motoristas);
		
		System.out.println("\n==Excluir Motorista");
		
		System.out.println("Informe o ID do motorista para excluir: ");
		int IdMotorista = in.nextInt() - 1;
		
		if (motoristas.size() <= IdMotorista) {
			System.out.println("\nAluno não cadastrado.");
			return null;
		}
		motoristas.remove(IdMotorista);
		System.out.println("Motorista Excluido");
		return null;
		
		
	}

	private List<Motorista> editarMotorista(List<Motorista> motoristas, List<Veiculo> veiculos) {
		if (veiculos.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return null;
		}
		listarMotoristas(motoristas);
		
		Motorista motorista = new Motorista();
		VeiculoController veiculoController = new VeiculoController();
		System.out.print("Informe o Id do motorista para editar: ");
		int IdMotorista = in.nextInt() - 1;

		System.out.println("\n1) Editar o nome do motorista");
		System.out.println("2) Editar ano de nascimento do motorista");
		System.out.println("3) Editar a categoria de habilitação do motorista");
		System.out.println("4) Editar veiculo do motorista");
		

		System.out.print("\nInforme o campo para ser editado: ");
		int campo = in.nextInt();
		in.nextLine();
		
		switch (campo) {
		case 1:
			System.out.println("\n--Editar Nome--");
			
			System.out.println("Informe o novo nome: ");
			motorista.setNome(in.nextLine());
			
			motorista.setAnoDeNacimento(motoristas.get(IdMotorista).getAnoDeNacimento());
			motorista.setIdade(motoristas.get(IdMotorista).getIdade());
			motorista.setVeiculo2(motoristas.get(IdMotorista).getVeiculo2());
			motorista.setCategoriaHabilitacao(motoristas.get(IdMotorista).getCategoriaHabilitacao());
			
			System.out.println("\nNome alterado.");
			break;
		
		case 2:
			System.out.println("\n Editar ano de nascimento");
			
			System.out.println("Informe o novo ano de nascimento: ");
			motorista.setAnoDeNacimento(in.nextInt());
			
			motorista.setIdade(motoristas.get(IdMotorista).getIdade());
			motorista.setVeiculo2(motoristas.get(IdMotorista).getVeiculo2());
			motorista.setNome(motoristas.get(IdMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(IdMotorista).getCategoriaHabilitacao());
			
			System.out.println("\nAno de nascimento alterado.");
			break;
		
		case 3:
			System.out.println("\nEditar Habilitação");
			
			System.out.println("Informe a nova categoria: ");
			motorista.setCategoriaHabilitacao(in.nextLine());
			motorista.setIdade(motoristas.get(IdMotorista).getIdade());
			motorista.setVeiculo2(motoristas.get(IdMotorista).getVeiculo2());
			motorista.setNome(motoristas.get(IdMotorista).getNome());
			
			System.out.println("\nCategoria Alterada");
			break;
		case 4:
			System.out.println("\nEditar veiculo");
			Veiculo veiculo = new Veiculo();
			veiculo.setAno(veiculos.get(IdMotorista).getAno());
			veiculo.setMarca(veiculos.get(IdMotorista).getMarca());
			veiculo.setModelo(veiculos.get(IdMotorista).getModelo());
			veiculo.setPlaca(veiculos.get(IdMotorista).getPlaca());
			veiculo.setTipoCombustivel(veiculos.get(IdMotorista).getTipoCombustivel());
		
			System.out.println("Informe o novo veiculo: ");
			motorista.setVeiculo2(veiculo);
			motorista.setNome(motoristas.get(IdMotorista).getNome());
			motorista.setCategoriaHabilitacao(in.nextLine());
			motorista.setIdade(motoristas.get(IdMotorista).getIdade());
			
			System.out.println("\nVeiculo Editado");
			break;
			
	}
		motoristas.set(IdMotorista, motorista);
		return motoristas;
	}

	public List<Motorista> listarMotoristas(List<Motorista> motoristas) {
		if (motoristas.isEmpty()) {
			System.out.println("\nNão possui alunos cadastrados.");
			return null;
		}
		System.out.println("\n=== MOTORISTAS CADASTRADOS ===");
		
		System.out.printf("|10%s | 4%s| 3%s| 10%s|\n","Nome","AnodeNascimento","TipoDeHabilitação","Veiculo");
		
		for (int i = 0; i < motoristas.size(); i++) {
			System.out.printf("|10%s | 4%d| 3%s| 10%s|\n", i + 1, motoristas.get(i).getAnoDeNacimento(),motoristas.get(i).getCategoriaHabilitacao(),
					motoristas.get(i).getIdade(),motoristas.get(i).getNome(),motoristas.get(i).getVeiculo2());
	}
		return motoristas;
	}

	public Motorista cadastrarMotorista(List<Veiculo> veiculos, List<Motorista> motoristas) {
		if (veiculos.isEmpty()) {
			System.out.println("\nNão possui veiculos cadastrados.");
			return null;
		}
		
		System.out.println("--Cadastrar Motorista--");
		
		VeiculoController veiculoController = new VeiculoController();
		Motorista motorista = new Motorista();
		
		veiculoController.listarVeiculos(veiculos);
		
		System.out.println("Dados do veiculo");
		
		System.out.println("Informe IDveiculo do motorista: ");
		int IDVeiculo = in.nextInt() - 1;
		
		motorista.setVeiculo2(veiculos.get(IDVeiculo));
		
		System.out.println("\n Dados do motorista ");
		
		in.nextLine();
		
		System.out.print("Informe o nome: ");
		motorista.setNome(in.nextLine());

		System.out.print("Informe o ano de nascimento: ");
		motorista.setAnoDeNacimento(in.nextInt());


		System.out.print("Informe o tipo de habilitação: ");
		motorista.setCategoriaHabilitacao(in.nextLine());
		
		
		return motorista;
	}
		
		
		
	}


