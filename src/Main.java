public class Main {
    public static void main(String[] args) {
        var conta = new Conta("54321", 500);
        conta.consultaSaldo();
        conta.verificarChequeEspecial();
        conta.pagarBoleto(501);
        conta.consultaSaldo();
        conta.sacar(500);
        conta.sacar(30);
        conta.sacar(19);
        conta.sacar(1);
        conta.sacar(0.1);
        conta.depositar(800);
        conta.consultaSaldo();
        conta.verificarChequeEspecial();
        conta.pagarBoleto(501);
        conta.consultaSaldo();
        conta.verificarChequeEspecial();
        conta.sacar(500);
        conta.consultaSaldo();
        conta.sacar(500);
        conta.consultaSaldo();
        conta.sacar(500);
        conta.consultaSaldo();
        conta.sacar(420);
        conta.consultaSaldo();
    }
}
