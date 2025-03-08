public class Conta {
    private String conta;

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private double saldo;
    private double chequeEspecial;

    public Conta(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double consultaSaldo(double saldo) {
        return saldo;
    }

    public double sacar(double saldo, double valor) {
        return saldo = saldo - valor;
    }

    public double depositar(double saldo, double valor) {
        return saldo + valor;
    }

    public void pagarBoleto(double saldo, double boleto) {
        saldo = saldo - boleto;
        System.out.println("Boleto pago");
    }

    public void verificarChequeEspecial() {
        if (chequeEspecial > 0) {
            System.out.println("Cheque Especial em uso.");
        } else {
            System.out.println("Sem uso de Cheque Especial.");

        }
    }
}
