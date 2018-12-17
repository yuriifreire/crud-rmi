import java.rmi.*;
import java.util.*;
import java.io.*;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	public Cliente() {

		System.out.println("Iniciando o Cliente...");
		try {
			servidor = (Servidor) Naming.lookup("rmi://127.0.0.1/ServidorTeste");
		} catch (Exception e) {
			System.out.println("Inicializacao do cliente falhou.\n" + e);
			e.printStackTrace();
			System.exit(0);
		}

	}

	public static void main(String[] args) {

		Cliente main = new Cliente();
		Scanner sc = new Scanner(System.in);
		int digit;
		while (true) {
			main.menu();
			digit = sc.nextInt();
			main.principal(digit);
		}
	}

	public void menu() {
		System.out.println(".: Republica IFRN :.");
		System.out.println("--------Menu--------");
		System.out.println("1 - Adicionar Estudante");
		System.out.println("2 - Listar Estudante");
		System.out.println("3 - Atualizar Estudante");
		System.out.println("4 - Remover Estudante");
		System.out.println("5 - Sair");
	}

	public void principal(int digit) {
		try {
			switch (digit) {
			case 1:
				Estudante estudante = new Estudante(0);
				Scanner sc = new Scanner(System.in);
				System.out.println("Informe matricula do estudante: ");
				String matricula = sc.nextLine();
				estudante.setMatricula(matricula);
				System.out.println("Informe nome do estudante: ");
				String nome = sc.nextLine();
				estudante.setNome(nome);
				System.out.println("Informe o endereço: ");
				String endereco = sc.nextLine();
				estudante.setEndereco(endereco);
				servidor.criaEstudante(estudante);
				break;
			case 2:
				if (!servidor.listaEstudantes().isEmpty()) {
					System.out.println("--------------------------------------");
					for (Estudante est : servidor.listaEstudantes()) {
						System.out.println("ID - |" + est.getId() + "|");
						System.out.println("MATRICULA - |" + est.getMatricula() + "|");
						System.out.println("NOME - |" + est.getNome() + "|" );
						System.out.println("ENDEREÇO - |" + est.getEndereco()+ "|");
					}
				} else {
					System.out.println("Não existem estudantes cadastrados");
				}

				break;
			case 3:
				Scanner scan = new Scanner(System.in);
				System.out.println("Informe o ID do estudante: ");
				int id = scan.nextInt();
				Scanner scans = new Scanner(System.in);
				System.out.println("Digite a nova matricula: ");
				String newMatricula = scans.nextLine();
				System.out.println("Digite o novo nome: ");
				String newNome = scans.nextLine();
				System.out.println("Digite o novo endereco: ");
				String newEndereco = scans.nextLine();

				servidor.attEstudante(id, newMatricula, newNome, newEndereco);

				break;
			case 4:
				Scanner scann = new Scanner(System.in);
				System.out.println("Informe o ID do estudante para remover: ");
				servidor.deletarEstudante(scann.nextInt());
				System.out.println("Estudante removido!");
				break;
			case 5:
				System.out.println("Finalizando programa... ");
				System.exit(0);
			default:
				System.out.println("Valor inválido");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Servidor servidor;
}