import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorLocacao {
	private Scanner sc;
	private ArrayList<Midia> midias;
	private ArrayList<Cliente> clientes;
	private ArrayList<Locacao> locacoes;
	private int numDeClientes = 0;


	// construtor
	public GerenciadorLocacao(Scanner sc) {
		this.sc = sc; // usa o scanner iniciado no main
		midias = new ArrayList<>();
		clientes = new ArrayList<>();
		locacoes = new ArrayList<>();
	}

// =================================================================================================

	//cadastro de midias novas
	public void cadastrarMidia() {
		// menu
		System.out.println("\n==== CADASTRO DE MIDIA ====\n" +
		                   "1. Fita VHS\n" +
		                   "2. DVD\n" +
		                   "3. Streaming\n" +
		                   "Escolha o tipo de midia: ");
		int opcao = sc.nextInt();
		sc.nextLine();

		// valida se a opcao selecionada e valida
		if (opcao != 1 && opcao != 2 && opcao != 3) {
			System.out.println("Opcao invalida");
			return;
		}

		// solicita info da midia a ser cadastrada
		System.out.print("Titulo: ");
		String titulo = sc.nextLine();
		System.out.print("Preco base: ");
		double preco = sc.nextDouble();
		sc.nextLine();

		// inicializa a midia nova que sera inserida na lista
		Midia novaMidia = null;

		switch (opcao) {
		case 1:
			System.out.print("A fita esta rebobinada? (true/false): ");
			boolean rebobinada = sc.nextBoolean();
			novaMidia = new FitaVHS(titulo, preco, rebobinada);
			break;

		case 2:
			System.out.print("O DVD possui extras? (true/false): ");
			boolean extras = sc.nextBoolean();
			novaMidia = new DVD(titulo, preco, extras);
			break;

		case 3:
			System.out.print("Plataforma de streaming: ");
			String plataforma = sc.nextLine();
			novaMidia = new Streaming(titulo, preco, plataforma);
			break;

		}

		// adiciona na lista a midia nova
		midias.add(novaMidia);
		System.out.println("Midia cadastrada com sucesso.");
	}

	// listagem de midias cadastradas
	public void listarMidias() {
		System.out.println("\n===== LISTA DE MIDIAS =====");
		for (Midia m : midias) {
			System.out.println(m);
		}
	}

// =================================================================================================

	// cadastro de clientes
	public void cadastrarCliente() {
		System.out.println("\n===== CADASTRO DE CLIENTE =====");
		System.out.print("Nome: ");
		String nome = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		// cria um cliente novo e usa o atributo numDeClientes para atribuir ao ID do cliente
		Cliente novoCliente = new Cliente(nome, email, numDeClientes);
		clientes.add(novoCliente);
		numDeClientes++;

		System.out.println("Cliente cadastrado com sucesso.");
	}

	// listagem de clientes cadastrados
	public void listarClientes() {
		System.out.println("\n===== LISTA DE CLIENTES =====");
		for (Cliente c : clientes) {
			System.out.println(c);
		}
	}

// =================================================================================================

	// funcao para fazer a locacao das midias
	public void realizarLocacao() {
// ------------------------------- SELECAO DE CLIENTE -------------------------------

		// lista os clientes cadastrados para depois selecionar um deles
		listarClientes();

		// selecao de um cliente cadastrado
		System.out.print("Digite o ID do cliente que vai realizar a locacao: ");
		int idCliente = sc.nextInt();
		sc.nextLine();

		// procura pelo cliente com o ID digitado anteriormente
		Cliente clienteSelecionado = null;
		for (Cliente c : clientes) {
			if (c.getId() == idCliente) {
				clienteSelecionado = c;
				break;
			}
		}

		// validacao para caso o ID digitado nao pertenca a nenhum cliente
		if (clienteSelecionado == null) {
			System.out.println("Cliente nao encontrado.");
			return;
		}

// ------------------------------- SELECAO DE MIDIA -------------------------------

		// lista as midis disponiveis para locacao
		System.out.println("\n===== MIDIAS DISPONIVEIS =====");
		for (int i = 0; i < midias.size(); i++) {
			Midia m = midias.get(i);
			if (m.isDisponivel()) {
				System.out.println(i + " - " + m);
			}
		}

		// selecao da midia que o cliente deseja alugar
		System.out.print("Digite o id da midia que deseja alugar: ");
		int indice = sc.nextInt();
		sc.nextLine();

		// validacao para caso a selecao esteja invalida
		if (indice < 0 || indice >= midias.size()) {
			System.out.println("Id invalido.");
			return;
		}

		// puxa a midia selecionada
		Midia midiaEscolhida = midias.get(indice);

		// validacao se a midia esta mesmo disponivel
		if (!midiaEscolhida.isDisponivel()) {
			System.out.println("Esta midia nao esta disponivel.");
			return;
		}

		// solicita info pra locacao
		System.out.print("Quantos dias de locacao? ");
		int dias = sc.nextInt();
		sc.nextLine();

		// cria a locacao e passa as informacoes para ela
		Locacao novaLocacao = new Locacao();
		novaLocacao.Aluguel(clienteSelecionado, midiaEscolhida);
		novaLocacao.setDiasDeLocacao(dias);
		novaLocacao.setEstaLocado(true);
		novaLocacao.calcularValorTotal();

		midiaEscolhida.setDisponivel(false); // marca a midia como alugada
		locacoes.add(novaLocacao); // adiciona a locacao nova na lista de locacoes

		System.out.println("\nLocacao realizada com sucesso.");
	}

// =================================================================================================

	// devolucao das midias locadas
	public void devolverMidia() {
		// validacao
		if (locacoes.isEmpty()) {
			System.out.println("\nNao ha locacoes registradas.");
			return;
		}

		// lista as locacoes que ainda estao ativas
		System.out.println("\n===== LOCACOES ATIVAS =====");
		for (int i = 0; i < locacoes.size(); i++) {
			Locacao l = locacoes.get(i);
			if (l.isEstaLocado()) {
				System.out.println(i + " - " +
				                   "Cliente: " + l.getCliente().getNome() +
				                   " | Midia: " + l.getMidia().getNome());
			}
		}

		// selecao
		System.out.print("\nDigite o id da locacao que deseja devolver: ");
		int indice = sc.nextInt();
		sc.nextLine();

		// validacao
		if (indice < 0 || indice >= locacoes.size() || !locacoes.get(indice).isEstaLocado()) {
			System.out.println("Opcao invalida.");
			return;
		}

		Locacao locacao = locacoes.get(indice);

		// marcar como devolvida e atribui midia como disponivel novamente
		locacao.setEstaLocado(false);
		locacao.getMidia().setDisponivel(true);

		System.out.println("\nMidia \"" + locacao.getMidia().getNome() + "\" devolvida com sucesso.");
	}

	// listagem das locacoes
	public void listarLocacoes() {
		System.out.println("\n===== HISTORICO DE LOCACOES =====");

		for (int i = 0; i < locacoes.size(); i++) {
			Locacao l = locacoes.get(i);
			String status = l.isEstaLocado() ? "EM ABERTO" : "DEVOLVIDA";

			System.out.println("\nLocacao #" + i + "\n" +
			                   "Cliente: " + l.getCliente().getNome() + "\n" +
			                   "Midia: " + l.getMidia().getNome() + "\n" +
			                   "Dias de locacao: " + l.getDiasDeLocacao() + "\n" +
			                   "Valor total: R$ " + l.getValorTotal() + "\n" +
			                   "Status: " + status + "\n");
		}
	}

// =================================================================================================

	// funcao para printar o total que a locadora arrecadou
	public void mostrarTotalArrecadado() {
		double total = 0;

		for (Locacao l : locacoes) {
			total += l.getValorTotal();
		}

		System.out.println("\n===== TOTAL ARRECADADO =====");
		System.out.printf("R$ %.2f\n", total);
	}
}
