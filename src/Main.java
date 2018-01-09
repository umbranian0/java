
import javax.swing.JOptionPane;

public class Main {

	static int quantosProjetos = 1;

	static String[] nomeProjetos = new String[quantosProjetos];
	static String[] nomesEtapas = { "Joaquina", "Maria Leal" };;// = new String
	// [Integer.parseInt(JOptionPane.showInputDialog("Etapas"))];
	static int[][] atributosEtapas = { { 3, 3, 3 }, { 5, 5, 5 } };;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		opcao();
	}

	public static void opcao() {
		char opcao = '0';
		do {
			opcao = lerOpcao('4');
			processarOpcao(opcao);
		} while (opcao != 0);
	}

	public static char lerOpcao(char maximo) {
		char opcao = 0;

		do {

			String op = JOptionPane.showInputDialog(
					"----- Gestao de Projetos ------ \n 1 - Projetos \n 2 - Listar (Projeto e etapas) \n"
							+ " 3 - Alterar \n 4 - Menu Perguntas \n" + " 0 - Sair ",
					null);
			opcao = op.charAt(0);

		} while (opcao > maximo || opcao < 0);
		return opcao;
	}

	// menu
	public static void processarOpcao(char opcao) {
		switch (opcao) {
		case '1':
			lerProjeto();
			break;
		case '2':
			listar();
			break;
		case '3':
			alterar();
			break;
		case '4':
			perguntas();
			break;
		case '0':
			sair();
			break;
		default:
			break;
		}
	}

	// metodo para ler o nome do projeto
	public static void lerProjeto() {
		// lerNome();

		inserirNomesDosProjetos(lerNome()); // manda variaveis para ler etapas e
											// duracao do projeto
		lerEtapasDumProjeto(lerEtapas());

	}

	public static String lerNome() {
		String nome = "";

		do {
			nome = JOptionPane.showInputDialog("nome do projeto :");
			// nome = JOptionPane.showInternalInputDialog(null, "Nome",
			// "Definições do Projeto",
			// JOptionPane.QUESTION_MESSAGE);
		} while (nome == "");
		return nome;
	}

	public static String[] inserirNomesDosProjetos(String nome) {

		for (int proj = 0; proj < nomeProjetos.length; proj++)
			nomeProjetos[proj] = nome;

		return nomeProjetos;
	}

	// leitura das etapas
	public static int lerEtapas() {
		int etapas = 0;
		do {
			try {// proteção contra entrada de dados errados (letras)
				etapas = Integer.parseInt(JOptionPane.showInputDialog("etapas necessarias "));
			} catch (Exception e) {
				etapas = -1;// aqui estamos a atribuir as etapas um numero
							// invalido para ele voltar ao Do while
			}

		} while (etapas <= 0);

		return etapas;
	}

	public static int[][] lerEtapasDumProjeto(int etapa) {
		// [5] = quantidade etapas [3]descriçao das etapas (duracao etc)
		// int[][] nrEtapas = new int[etapa][4];

		String[] atrib = new String[4]; // INICIO VERSÃO 1
		atrib[0] = "Duração";
		atrib[1] = "Dias Exclusivos";
		atrib[2] = "Folga";
		atrib[3] = "Dias Recicláveis";

		// declara o vetor atributos das Etapas
		atributosEtapas = new int[etapa][4];
		lernomeEtapas(etapa);

		// descricao das varias etapas das etapas
		for (int etap = 0; etap < atributosEtapas.length; etap++)
			for (int desc = 0; desc < atributosEtapas[0].length; desc++)
				atributosEtapas[etap][desc] = Integer.parseInt(
						JOptionPane.showInputDialog("Etapa [" + nomesEtapas[etap] + "] \n" + atrib[desc] + ": "));
		return atributosEtapas;
	}

	// le nome de cada etapa do projeto
	public static void lernomeEtapas(int etapas) {
		nomesEtapas = new String[etapas];
		for (int i = 0; i < etapas; i++)
			nomesEtapas[i] = JOptionPane.showInputDialog("nome da etapa [" + (i + 1) + "] = ");
	}

	// listar nomes do projeto e etapas opçao 2
	public static void listar() {
		int proj; // Vai guardar o numero do projeto que o utilizador vai querer
					// listar
		for (int i = 0; i <= nomeProjetos.length - 1; i++) {
			proj = Integer.parseInt(JOptionPane.showInputDialog(
					"-----------consultar ------------\n Projeto " + (i + 1) + " - " + nomeProjetos[i] + ";"));
			listarProj(proj);
		}
	}

	public static void listarProj(int proj) {
		String s = "";

		String[] atrib = new String[4];
		atrib[0] = "Duração";
		atrib[1] = "Dias Exclusivos";
		atrib[2] = "Folga";
		atrib[3] = "Dias Recicláveis";

		for (int etap = 0; etap < atributosEtapas.length; etap++) {
			s = s + "----Etapa :" + nomesEtapas[etap] + "----\n";
			for (int desc = 0; desc < atributosEtapas[0].length; desc++) {
				s = s + " " + atrib[desc] + " - " + atributosEtapas[etap][desc] + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, s);
	}

	// menu para alterar dados
	public static void alterar() {
		int op = 0;
		do {
			try {

				op = Integer.parseInt(JOptionPane
						.showInputDialog(" 1- Alterar nome do projeto" + " \n 2 - editar nome de etapas \n 0- Sair"));
			} catch (Exception e) {
				op = -1;// aqui estamos a atribuir as etapas um numero invalido
						// para ele voltar ao Do while
			}
		} while (op < 0);

		switch (op) {
		case 1:
			mudarNome(nomeProjetos);
			break;
		case 2:
			mudarNome(nomesEtapas);
			break;

		default:
			break;
		}
	}

	// modolo que vai servir para mudar nome de vetores
	public static String[] mudarNome(String[] vetorNomes) {

		int indice = 0;
		indice = Integer.parseInt(JOptionPane.showInputDialog(" qual o indice do Projeto para alterar"));
		vetorNomes[indice] = JOptionPane.showInputDialog("novo nome");
		return vetorNomes;

	}

	// menu para as perguntas
	public static void perguntas() {
		int op = 0;
		do {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(
						" 1- Duraçao do projeto \n 2 - duracao minima do projeto \n 3 - duraçao maxima do projeto \n 4 - Mostrar Grafico \n 0 - Sair"));
			} catch (Exception e) {
				op = -1;// aqui estamos a atribuir as etapas um numero invalido
						// para ele voltar ao Do while
			}
		} while (op < 0 || op > 4);

		switch (op) {
		case 1:// duracao do projeto (normal)
			JOptionPane.showMessageDialog(null, duracaoProjeto(atributosEtapas));
			break;
		case 2: // duracao minima do projeto
			JOptionPane.showMessageDialog(null, duracaoProjeto(atributosEtapas) - duracaoMinima(atributosEtapas));
			break;
		case 3:// duracao maxima
			JOptionPane.showMessageDialog(null, duracaoMaxima(atributosEtapas) + duracaoProjeto(atributosEtapas));
			break;
		case 4:
			JOptionPane.showMessageDialog(null, graficoNum(atributosEtapas) + "\n" + graficoLetra(atributosEtapas));
		default:
			break;
		}

	}

	public static String graficoNum(int tabela[][]) {
		String x = "";

		int aux = 0;
		for (int i = 1; i <= duracaoProjeto(tabela); i++)
			do {
				x = x + " " + i + " \n";// vamos ecrever os nrs da duraçao
				aux++;
			} while (aux < i);

		return x;

	}

	public static String graficoLetra(int tabela[][]) {
		String x = "";
		for (int j = 0; j < tabela.length; j++) {

			int n = 0;
			do {
				x = x + " " + nomesEtapas[j].charAt(0) + " \n";
				n++;
			} while (n < tabela[j][0]);
		}

		return x;
	}

	public static int duracao(int duracaoEtapas[][], int coluna) {
		int soma = 0;
		for (int i = 0; i < duracaoEtapas.length; i++)
			soma += duracaoEtapas[i][coluna];
		return soma;
	}

	// soma das etapas
	public static int duracaoProjeto(int duracaoEtapas[][]) {

		return duracao(duracaoEtapas, 0);
	}

	// soma dos dias reciclaveis
	public static int duracaoMinima(int duracaoEtapas[][]) {

		return duracao(duracaoEtapas, 3);
	}

	// soma das folgas
	public static int duracaoMaxima(int duracaoEtapas[][]) {
		return duracao(duracaoEtapas, 2);
	}

	public static void sair() {
		JOptionPane.showMessageDialog(null, "-------- Sair -------- "
				+ "\n ------------------- Realizado por: \n --------------------Vasile Timotin \n --------------------Rafael Barradas ");
		System.exit(0);
	}
}
