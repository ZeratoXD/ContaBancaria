package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController ();
		
		Scanner leia = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		
		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(123457, 123, 2, "João dos Santos", 2500.0f, 1000f);
		cc1.visualizar();
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		// Teste da Classe Conta poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		cc1.visualizar();

		System.out.println("Nome do Titular: " + cc1.getTitular());
		System.out.println("Saldo da Conta: " + cc1.getSaldo());
		System.out.println("");

		cc1.setSaldo(10000.0f);
		System.out.println("Saldo da Conta: " + cc1.getSaldo());

		int opcao1;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.ANSI_RED_BACKGROUND);

			opcao1 = leia.nextInt();

			if (opcao1 == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao1) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Digite o Numero da Agencia: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP):  ");
					tipo = leia.nextInt();
				}while(tipo < 1 && tipo >2);
				
				System.out.println("Digite o saldo da Conta (R$) :  ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de Crédito (R$) :  ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}case 2 -> {
						System.out.println("Digite o limite de Crédito (R$) :  ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
		
			}
				
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
                contas.listarTodas(); 
                keyPress();
                break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");

				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}

		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
