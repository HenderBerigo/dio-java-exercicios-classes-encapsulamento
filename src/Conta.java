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
        if (depositar >= 500) {

            this.chequeEspecial = depositar * (-0.5);
        } else {
            this.chequeEspecial =  -50;
        }
        this.saldo = saldo + depositar;
        this.conta = setConta;
    }

    public void consultaSaldo() {
        System.out.println("O saldo é R$ " + saldo);
    }

    public void sacar(double valor) {
        var saldoTotal = saldo + (-chequeEspecial);
        if (saldo < valor && valor <= saldoTotal) {
            var valorTemp = valor - saldo;
            saldo = 0;
            chequeEspecial = chequeEspecial - (valorTemp*2);
            chequeEspecial += chequeEspecial *0.2;
            System.out.println("Saque de R$ " + valor + ", feito com sucesso!");
            System.out.println("Saldo atualizado: R$" + saldo);
            System.out.println("Cheque Especial: R$" + chequeEspecial);
        } else if (saldo > valor) {
            saldo = saldo - valor;
            System.out.println("Saque de R$ " + valor + ", feito com sucesso!");
            System.out.println("Saldo atualizado: R$" + saldo);

        } else {
            System.out.println("Saldo insuficitente para sacar R$ " + valor);
            System.out.println("Saldo atualizado: R$" + saldo);
            System.out.println("Cheque Especial: R$" + chequeEspecial);
        }
    }

        public double depositar(double valor) {
            if(saldo < 0 && chequeEspecial < 0){ // Saldo e ChequeEspecial menor que 0
                chequeEspecial += chequeEspecial + valor;
            }
            if (valor >= 500) {

                this.chequeEspecial = chequeEspecial - (valor * 0.5);
            } else {
                this.chequeEspecial = chequeEspecial - 50;
            }
            System.out.println("Depósito de R$" + valor + " feito.");
            saldo = saldo + valor;
            System.out.println("Saldo atualizado: R$" + saldo);
            return saldo;
        }
    

    public void pagarBoleto(double boleto) {
        if (boleto < saldo) {
            saldo = saldo - boleto;
            System.out.println("Boleto de R$ " + boleto + " pago.");
            System.out.println("Saldo atualizado: R$" + saldo);

        } else {
            System.out.println("Saldo insuficiente para pagar o boleto de R$ " + boleto);
            System.out.println("Saldo atual: R$" + saldo);
        }
    }

    public void verificarChequeEspecial() {
        if (chequeEspecial < 0) {
            System.out.println("Cheque Especial em uso de R$ " + chequeEspecial);

        } else {
            System.out.println("Sem uso de Cheque Especial.");

        }
    }
}
