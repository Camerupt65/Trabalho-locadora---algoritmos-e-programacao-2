import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GerenciadorLocacao gerenciador = new GerenciadorLocacao(sc);
		int opcao = 1;


		do {
			System.out.println("\n============ MENU ============\n" +
			                   "1 - Cadastrar nova midia\n" +
			                   "2 - Listar midias\n" +
			                   "------------------------------\n" +
			                   "3 - Cadastrar novo cliente\n" +
			                   "4 - Listar clientes\n" +
			                   "------------------------------\n" +
			                   "5 - Realizar locacao\n" +
			                   "6 - Devolucao de midia\n" +
			                   "7 - Listar historico de locacoes\n" +
			                   "------------------------------\n" +
			                   "8 - Mostrar total arrecadado\n" +
			                   "0 - Sair\n" +
			                   "==============================");

			opcao = sc.nextInt();
			sc.nextLine();


			switch(opcao) {
			case 1:
				gerenciador.cadastrarMidia();
				break;

			case 2:
				gerenciador.listarMidias();
				break;

			case 3:
				gerenciador.cadastrarCliente();
				break;

			case 4:
				gerenciador.listarClientes();
				break;

			case 5:
				gerenciador.realizarLocacao();
				break;

			case 6:
				gerenciador.devolverMidia();
				break;

			case 7:
				gerenciador.listarLocacoes();
				break;

			case 8:
				gerenciador.mostrarTotalArrecadado();
				break;

			case 0:
				System.out.println("Encerrando o sistema...");
				break;

			default:
				System.out.println("Opcao invalida.\n");
			}
		} while (opcao != 0);
	}
}
