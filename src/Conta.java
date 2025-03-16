public class Conta {
    private String conta;
    private double saldo;
    private double chequeEspecial;  // Limite do cheque especial
    private double dividaChequeEspecial;  // Dívida efetiva no cheque especial

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

    // Construtor da conta
    public Conta(String setConta, double depositar) {
        this.conta = setConta;
        this.saldo = depositar;

        // Definir o limite do cheque especial com base no depósito
        if (depositar >= 500) {
            this.chequeEspecial = depositar * 0.5;  // Cheque especial é 50% do valor depositado
        } else {
            this.chequeEspecial = 50;  // Se o depósito for menor que R$ 500, o limite do cheque especial é R$ 50
        }

        this.dividaChequeEspecial = 0;  // Inicialmente, não há dívida no cheque especial
    }

    // Método para consultar o saldo
    public void consultaSaldo() {
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Cheque Especial (limite): R$ " + chequeEspecial);
        System.out.println("Limite Usado (dívida): R$ " + dividaChequeEspecial);
    }

    // Método para realizar saque
    public void sacar(double valor) {
        double taxa = 0;
        double valorRestante = 0;

        // Se o valor for menor ou igual ao saldo, apenas desconta do saldo
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            System.out.println("Saldo atualizado: R$ " + saldo);
        } else {
            // Se o saldo for insuficiente, usa o cheque especial
            valorRestante = valor - saldo;
            saldo = 0;  // Zera o saldo

            if (valorRestante <= chequeEspecial - dividaChequeEspecial) {
                // Deduz do cheque especial, mas não ultrapassa o limite
                dividaChequeEspecial += valorRestante;  // Atualiza a dívida no cheque especial
                taxa = valorRestante * 0.2;  // Calcula a taxa de 20% sobre o valor retirado do cheque especial
                dividaChequeEspecial += taxa;  // Deduz a taxa da dívida no cheque especial

                System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
                System.out.println("Saldo atualizado: R$ " + saldo);
                System.out.println("Cheque Especial (limite): R$ " + chequeEspecial);
                System.out.println("Limite Usado (dívida): R$ " + dividaChequeEspecial);
                System.out.println("Taxa aplicada: R$ " + taxa);
            } else {
                System.out.println("Saldo insuficiente para sacar R$ " + valor);
                System.out.println("Saldo atual: R$ " + saldo);
                System.out.println("Cheque Especial disponível: R$ " + (chequeEspecial - dividaChequeEspecial));
            }
        }
    }

    // Método para realizar depósito
    public void depositar(double valor) {
        // Primeiro paga-se a dívida do cheque especial, se houver
        if (dividaChequeEspecial > 0) {
            if (valor >= dividaChequeEspecial) {
                valor -= dividaChequeEspecial;  // Paga toda a dívida do cheque especial
                dividaChequeEspecial = 0;  // Zera a dívida
            } else {
                dividaChequeEspecial -= valor;  // Paga parte da dívida
                valor = 0;  // Não sobra valor para o saldo
            }
        }

        // O restante do depósito vai para o saldo
        saldo += valor;

        // Se o valor depositado for maior que 500, aumenta o limite do cheque especial
        if (valor >= 500) {
            chequeEspecial += valor * 0.5;  // Aumenta o limite do cheque especial
        } else {
            chequeEspecial += 50;  // Se o valor for menor, aumenta R$ 50 no limite do cheque especial
        }

        System.out.println("Saldo atualizado: R$ " + saldo);
        System.out.println("Cheque Especial (limite): R$ " + chequeEspecial);
        System.out.println("Limite Usado (dívida): R$ " + dividaChequeEspecial);
    }

    // Método para pagar boletos
    public void pagarBoleto(double boleto) {
        double taxa = 0;
        double valorRestante = 0;

        if (boleto <= saldo) {
            saldo -= boleto;
            System.out.println("Boleto de R$ " + boleto + " pago.");
            System.out.println("Saldo atualizado: R$ " + saldo);
        } else {
            valorRestante = boleto - saldo;
            saldo = 0;

            if (valorRestante <= chequeEspecial - dividaChequeEspecial) {
                dividaChequeEspecial += valorRestante;  // Atualiza a dívida no cheque especial
                taxa = valorRestante * 0.2;  // Calcula a taxa de 20% sobre o valor utilizado do cheque especial
                dividaChequeEspecial += taxa;  // Deduz a taxa da dívida no cheque especial

                System.out.println("Boleto de R$ " + boleto + " pago.");
                System.out.println("Saldo atualizado: R$ " + saldo);
                System.out.println("Cheque Especial (limite): R$ " + chequeEspecial);
                System.out.println("Limite Usado (dívida): R$ " + dividaChequeEspecial);
                System.out.println("Taxa aplicada: R$ " + taxa);
            } else {
                System.out.println("Saldo insuficiente para pagar o boleto de R$ " + boleto);
                System.out.println("Saldo atual: R$ " + saldo);
                System.out.println("Cheque Especial disponível: R$ " + (chequeEspecial - dividaChequeEspecial));
            }
        }
    }

    // Método para verificar o cheque especial
    public void verificarChequeEspecial() {
        if (dividaChequeEspecial > 0) {
            System.out.println("Cheque Especial em uso de R$ " + dividaChequeEspecial);
        } else {
            System.out.println("Sem uso de Cheque Especial.");
        }
    }
}




// public class Conta {
//     private String conta;
//     private double saldo;
//     private double chequeEspecial;
//     public char[] consultaSaldo;
    

//     public String getConta() {
//         return conta;
//     }

//     public void setConta(String conta) {
//         this.conta = conta;
//     }

//     public double getSaldo() {
//         return saldo;
//     }

//     public void setSaldo(double saldo) {
//         this.saldo = saldo;
//     }

//     public Conta(String setConta, double depositar) {
//         if (depositar >= 500) {

//             this.chequeEspecial = depositar * (0.5);
            
//         } else {
//             this.chequeEspecial =  50;
//         }
//         this.saldo = depositar;
//         this.conta = setConta;
        
//     }

//     public void consultaSaldo() {
//         System.out.println("O saldo é R$ " + saldo);
//     }

//     public void sacar(double valor) {
//         var saldoTotal = saldo + chequeEspecial;
//         var taxa = valor*0.2;
//         if(saldo >= valor && chequeEspecial == 0){

//             saldo = saldo - valor;
//             System.out.println("Saque de R$ " + valor + ", feito com sucesso!");
//             System.out.println("Saldo atualizado: R$" + saldo);

//         } else if (saldo == 0  && (valor+taxa) <= (chequeEspecial-taxa)) { 

//             chequeEspecial = chequeEspecial - valor;
//             chequeEspecial = chequeEspecial - valor *0.2;
//             System.out.println("Saque de R$ " + valor + ", feito com sucesso!");
//             System.out.println("Saldo atualizado: R$" + saldo);
//             System.out.println("Cheque Especial: R$" + chequeEspecial);
            
//         } else if (saldoTotal >= (valor+taxa)) { // saldoTotal maior que valor
            
//             var valorTemp = (valor - saldo);
//             if((valorTemp*0.2) < saldoTotal){
//                 saldo = 0;
//                 valorTemp += valorTemp*0.2;
//                 chequeEspecial = chequeEspecial - valorTemp;
                
//                 //saldo = saldo - valorTemp;
//                 System.out.println("Saque de R$ " + valor + ", feito com sucesso!");
//                 System.out.println("Saldo atualizado: R$" + saldo);
//                 System.out.println("Cheque Especial: R$" + chequeEspecial);
                
//             }  else {

//                 System.out.println("Saldo insuficitente para sacar R$ " + valor);
//                 System.out.println("Saldo atualizado: R$" + saldo);
//                 System.out.println("Cheque Especial: R$" + chequeEspecial);
//             }

//         } else {

//             System.out.println("Saldo insuficitente para sacar R$ " + valor);
//             System.out.println("Saldo atualizado: R$" + saldo);
//             System.out.println("Cheque Especial: R$" + chequeEspecial);
//         }
//     }
    
//     public void depositar(double valor) {
//         if(chequeEspecial == 0){
//             saldo = saldo + valor;
//             if (valor >= 500) {
                
//                 this.chequeEspecial = valor * (0.5);
                
//             } else {
//                 this.chequeEspecial =  50;
//             }
//         }else{
//             if(chequeEspecial > valor){
//                 chequeEspecial = chequeEspecial - valor;
//             } else {
//                 valor = valor - chequeEspecial;
//                 chequeEspecial = 0;
//                 saldo = saldo + valor;
//                 if (valor >= 500) {
                    
//                     this.chequeEspecial = valor * (0.5);
                    
//                 } else {
//                     this.chequeEspecial =  50;
//                 }
//             }
//         }
        
//         System.out.println("Saldo atualizado: R$" + saldo);
//         System.out.println("Cheque Especial: R$" + chequeEspecial);

//     }
    

//     public void pagarBoleto(double boleto) {
//         if (boleto < saldo) {
//             saldo = saldo - boleto;
//             System.out.println("Boleto de R$ " + boleto + " pago.");
//             System.out.println("Saldo atualizado: R$" + saldo);

//         } else {
//             System.out.println("Saldo insuficiente para pagar o boleto de R$ " + boleto);
//             System.out.println("Saldo atual: R$" + saldo);
//         }
//     }

//     public void verificarChequeEspecial() {
//         if (chequeEspecial > 0) {
//             System.out.println("Cheque Especial em uso de R$ " + chequeEspecial);

//         } else {
//             System.out.println("Sem uso de Cheque Especial.");

//         }
//     }
// }
