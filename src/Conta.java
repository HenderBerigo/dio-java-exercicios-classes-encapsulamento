public class Conta {
    private String conta;
    private double saldo;
    private double chequeEspecial;
    public char[] consultaSaldo;

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

    public Conta(String setConta, double depositar) {
        if (depositar > 500) {

            this.chequeEspecial = depositar * 1.5;
        } else {
            this.chequeEspecial = 50;
        }
        this.saldo = saldo + depositar;
        this.conta = setConta;
    }

    public void consultaSaldo() {
        System.out.println("O saldo é R$ " + saldo);
    }

    public void sacar(double valor) {
        var saldoTotal = saldo + chequeEspecial;
        if (saldoTotal >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque de R$ " + valor + ", feito com sucesso!");
            System.out.println("Novo saldo é de R$ " + saldo);
        } else {
            System.out.println("Saldo insuficitente para sacar R$ " + valor);
        }
    }

    public double depositar(double valor) {
        if (valor > 500) {

            this.chequeEspecial = valor * 1.5;
        } else {
            this.chequeEspecial = 50;
        }
        return saldo = saldo + valor;
    }

    public void pagarBoleto(double boleto) {
        if (boleto < saldo) {
            saldo = saldo - boleto;
            System.out.println("Boleto de R$ " + boleto + " pago.");

        } else {
            System.out.println("Saldo insuficiente para pagar o boleto de R$ " + boleto);
        }
    }

    public void verificarChequeEspecial() {
        if (chequeEspecial > 0) {
            System.out.println("Cheque Especial em uso de R$ " + chequeEspecial);

        } else {
            System.out.println("Sem uso de Cheque Especial.");

        }
    }
}
