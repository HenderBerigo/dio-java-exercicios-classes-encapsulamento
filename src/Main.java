import java.util.Scanner;
/*
**********
ajustar regra de negocio sobre limite para usar e limite usado

**********
*/

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** Sistema Conta ***");

        //System.out.print("Digite o número da Conta: ");
        // var numConta = scan.nextLine();
        var numConta = "531";
        //System.out.print("Digite o valor do Depósito: ");
        // var deptositoIncial = scan.nextDouble();
        var deptositoIncial = 500;
        var conta = new Conta(numConta, deptositoIncial);

        int escolhaMenu;
        do {
            Menu();
            escolhaMenu = scan.nextInt();

            switch (escolhaMenu) {
                case 1->conta.consultaSaldo();
                case 2->conta.verificarChequeEspecial();
                case 3->{
                    System.out.print("Qual o valor para o Depósito? ");double valorDeposito=scan.nextDouble();conta.depositar(valorDeposito);
                }
                case 4 -> {
                        System.out.print("Digite o valor do Boleto: ");double valorBoleto=scan.nextDouble();conta.pagarBoleto(valorBoleto);
                    }
                case 5 -> System.out.println("Número da Conta: " + conta.getConta());
                case 6->{
                    System.out.print("Qual o valor do saque? ");double valorSaque=scan.nextDouble();conta.sacar(valorSaque);
                }
                case 0->System.out.println("Saindo do sitema!");
                    default -> System.out.println("Opção inválida");

                    // case 1:
                    // conta.consultaSaldo();
                    // // Menu();
                    // break;
                    // case 2:
                    // conta.verificarChequeEspecial();
                    // // Menu();
                    // break;
                    // case 3:
                    // System.out.print("Qual o valor para o Depósito? ");
                    // double valorDeposito = scan.nextDouble();
                    // conta.depositar(valorDeposito);
                    // // Menu();
                    // break;
                    // case 4:
                    // System.out.print("Digite o valor do Boleto: ");
                    // double valorBoleto = scan.nextDouble();
                    // conta.pagarBoleto(valorBoleto);
                    // // Menu();
                    // break;
                    // case 5:
                    // System.out.println("Número da Conta: " + conta.getConta());
                    // // Menu();
                    // break;
                    // case 6:
                    // System.out.print("Qual o valor do saque? ");
                    // double valorSaque = scan.nextDouble();
                    // conta.sacar(valorSaque);
                    // // Menu();
                    // break;
                    // case 0:
                    // System.out.println("Saindo do sitema!");
                    // break;
                    // default:
                    // System.out.println("Opção inválida");
                    // // Menu();
                    // break;
            }
        } while (escolhaMenu != 0);
        // }
        // Menu();
    }

    public static void Menu() {

        System.out.println();
        System.out.println("Selecione a operação que deseja:");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Consultar Limite especial");
        System.out.println("3 - Fazer Depósito");
        System.out.println("4 - Pagar um Boleto");
        System.out.println("5 - Consultar o número da Conta");
        System.out.println("6 - Efetuar um Saque");
        System.out.println("0 - Sair");

    }
}
